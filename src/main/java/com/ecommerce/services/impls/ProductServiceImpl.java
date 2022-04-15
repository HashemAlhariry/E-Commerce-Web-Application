package com.ecommerce.services.impls;


import com.ecommerce.exceptions.CustomValidationException;
import com.ecommerce.presentation.beans.AddProductBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.ProductState;
import com.ecommerce.repositories.impl.CategoryRepositoryImpl;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;
import com.ecommerce.services.ProductService;
import com.ecommerce.utils.FileUtil;
import com.ecommerce.utils.S3Util;
import com.ecommerce.utils.mappers.ProductMapper;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class ProductServiceImpl implements ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductServiceImpl(String reqId) {
        categoryRepository = new CategoryRepositoryImpl(reqId);
        productRepository = new ProductRepositoryImpl(reqId);
    }


    @Override
    public ProductEntity save(AddProductBean addProductBean) throws IOException, CustomValidationException {


        if (addProductBean.getImages().isEmpty()) {
            throw new CustomValidationException("Images must be 1 at least");
        }

        Part mainImagePart = addProductBean.getImages().get(0);
        addProductBean.getImages().remove(0);
        String mainImgURI = saveMainImage(mainImagePart);

        if (mainImgURI.isEmpty()) {
            throw new CustomValidationException("Couldn't save main image");
        }

        Set<String> images = saveImages(addProductBean.getImages());
//        images.add(mainImgURI);

        CategoryEntity category = categoryRepository.findById(addProductBean.getCategoryId());
        if (category == null) {
            throw new CustomValidationException("Category not found");
        }
        ProductEntity productEntity = ProductMapper.INSTANCE.addProductBeanToEntity(addProductBean);
        productEntity.setMainImage(mainImgURI);
        productEntity.setImages(images);
        productEntity.setCreationDate(LocalDateTime.now());
        productEntity.setCategory(category);
        productEntity.setState(ProductState.NEW);
        productRepository.save(productEntity);
        return productEntity;
    }


    private Set<String> saveImages(List<Part> imageParts) throws IOException {

        Set<String> imageNames = new HashSet<>();
        for (Part imagePart : imageParts) {
            Optional<String> optionalFileName = FileUtil.getINSTANCE().getFileName(imagePart);
            if (optionalFileName.isEmpty()) {
                continue;
            }
            String imageName = optionalFileName.get();
            if (imageName.isEmpty()) {
                continue;
            }
            String imgUrl = S3Util.uploadFile(imageName, imagePart.getInputStream());
            imageNames.add(imgUrl);
        }
        return imageNames;
    }

    private String saveMainImage(Part imagePart) throws IOException {
        Optional<String> optionalFileName = FileUtil.getINSTANCE().getFileName(imagePart);
        if (optionalFileName.isEmpty()) {
            return "";
        }
        String imageName = optionalFileName.get();
        if (imageName.isEmpty()) {
            return "";
        }
        String imgUrl = S3Util.uploadFile(imageName, imagePart.getInputStream());
        return imgUrl;
    }

    @Override
    public boolean delete(ProductEntity entity) {
        return productRepository.delete(entity);
    }

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity update(ProductEntity entity) {
        System.out.println("inside th repo");
        return productRepository.update(entity);
    }

    @Override
    public List<ProductEntity> getLast10() {
        return productRepository.getLast10();
    }

    @Override
    public List<ProductEntity> findAllByCategoryId(int id) {
        return productRepository.findAllByCategoryId(id);
    }

    @Override
    public List<ProductBean> getAllProductBeans(List<Long> ids) {
        List<ProductBean> productBeans = new ArrayList<>();
        for (Long id : ids) {
            ProductEntity productEntity = productRepository.findById(id);
            ProductBean productBean = ProductMapper.INSTANCE.productEntityToBean(productEntity);
            productBeans.add(productBean);
        }
        return productBeans;
    }

    @Override
    public List<ProductBean> getProductsOfPage(int pageNumber) {
        int totalCount = getAllProductsCount();
        int countOfProductsPerPage = 12;
        int numberOfPages = (int) Math.ceil((float) totalCount / countOfProductsPerPage);
        if (pageNumber <= numberOfPages) {
//            List<ProductEntity> productEntitiesOfSinglePage = productRepository.getSinglePageProducts(pageNumber,countOfProductsPerPage);
            List<ProductEntity> productEntitiesOfSinglePage = productRepository.getSinglePageContent(pageNumber, countOfProductsPerPage);
            List<ProductBean> productBeansOfSinglePage = ProductMapper.INSTANCE.listEntitiesToBeans(productEntitiesOfSinglePage);
            return productBeansOfSinglePage;
        } else {
            return null;
        }

    }

    @Override
    public int getAllProductsCount() {
//        return productRepository.findAllProductsNumber();
        return productRepository.getCount();
    }


    @Override
    public List<ProductEntity> findProductByName(String productName) {
        return productRepository.findProductByName(productName);
    }

    @Override
    public List<ProductBean> getFilteredProductsBeans(int pageNumber, int recordsPerPage, List<String> categoriesIds) {
        int totalCount = getAllProductsCount();
        int countOfProductsPerPage = 12;
        int numberOfPages = (int) Math.ceil((float) totalCount / countOfProductsPerPage);
        if (pageNumber <= numberOfPages) {
            //List<ProductEntity> productEntitiesOfSinglePage = productRepository.getSinglePageProducts(pageNumber,countOfProductsPerPage);
            List<ProductEntity> filteredProductEntities = productRepository.getFilteredProducts(pageNumber, countOfProductsPerPage, categoriesIds);
            List<ProductBean> productBeansOfSinglePage = ProductMapper.INSTANCE.listEntitiesToBeans(filteredProductEntities);
            return productBeansOfSinglePage;
        } else {
            return null;
        }
    }

    @Override
    public long getProductsCountInCategories(String... categoriesIdArr) {
        java.util.List<String> categoriesId = java.util.Arrays.asList(categoriesIdArr);
        return productRepository.countProductsOfCertainCategories(categoriesId);
    }

    @Override
    public List<ProductEntity> findProductByPrice(BigDecimal productPrice) {
        return productRepository.findProductByPrice(productPrice);
    }

    @Override
    public List<ProductEntity> findProductByPriceAndCategoryId(BigDecimal productPrice, int id) {
        return productRepository.findProductByPriceAndCategoryId(productPrice, id);
    }

    @Override
    public List<ProductEntity> relatedProducts(int id) {
        return productRepository.relatedProducts(id);
    }

}
