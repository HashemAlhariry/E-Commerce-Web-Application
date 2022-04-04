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
import com.ecommerce.utils.mappers.ProductMapper;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class ProductServiceImpl implements ProductService {
    private static final ProductServiceImpl INSTANCE = new ProductServiceImpl();
    private final CategoryRepository categoryRepository = CategoryRepositoryImpl.getInstance();
    private final ProductRepository productRepository = ProductRepositoryImpl.getInstance();

    private ProductServiceImpl() {
    }

    public static ProductServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public ProductEntity save(AddProductBean addProductBean) throws IOException, CustomValidationException {


        Set<String> images = saveImages(addProductBean.getImages());
        if (images.isEmpty()) {
            throw new CustomValidationException("Images must be 1 at least");
        }
        CategoryEntity category = categoryRepository.findById(addProductBean.getCategoryId());
        if (category == null) {
            throw new CustomValidationException("Category not found");
        }
        ProductEntity productEntity = ProductMapper.INSTANCE.addProductBeanToEntity(addProductBean);

        productEntity.setImages(images);
        productEntity.setCreationDate(LocalDate.now());
        productEntity.setCategory(category);
        productEntity.setState(ProductState.NEW);
        productRepository.save(productEntity);
        return productEntity;
    }


    private Set<String> saveImages(Collection<Part> imageParts) throws IOException {
        Set<String> imageNames = new HashSet<>();
        UUID uuid;
        for (Part imagePart : imageParts) {
            uuid = UUID.randomUUID();
            Optional<String> optionalFileName = FileUtil.getINSTANCE().getFileName(imagePart);
            if (optionalFileName.isEmpty()) {
                continue;
            }
            String imageName = optionalFileName.get();
            if (imageName.isEmpty()) {
                continue;
            }
            imagePart.write(uuid.toString() + imageName);
            imageNames.add(uuid + imageName);
        }
        return imageNames;
    }

    @Override
    public boolean delete(ProductEntity entity) {
        return false;
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
        return null;
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
        int numberOfPages = (int)Math.ceil((float)totalCount/countOfProductsPerPage);
        if (pageNumber <= numberOfPages){
//            List<ProductEntity> productEntitiesOfSinglePage = productRepository.getSinglePageProducts(pageNumber,countOfProductsPerPage);
            List<ProductEntity> productEntitiesOfSinglePage = productRepository.getSinglePageContent(pageNumber,countOfProductsPerPage);
            List<ProductBean> productBeansOfSinglePage = ProductMapper.INSTANCE.listEntitiesToBeans(productEntitiesOfSinglePage);
            return productBeansOfSinglePage;
        }else{
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
}
