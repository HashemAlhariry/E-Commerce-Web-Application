package com.ecommerce.services.impls;


import com.ecommerce.exceptions.CustomValidationException;
import com.ecommerce.presentation.beans.AddProductBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.repositories.entites.ProductEntity;
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


        ProductEntity productEntity = new ProductEntity();
        Set<String> images = saveImages(addProductBean.getImages());
        if (images.isEmpty()) {
            throw new CustomValidationException("Images must be 1 at least");
        }
        CategoryEntity category = categoryRepository.findById(addProductBean.getCategoryId());

        productEntity.setName(addProductBean.getName());
        productEntity.setDescription(addProductBean.getDescription());
        productEntity.setPrice(addProductBean.getPrice());
        productEntity.setQuantity(addProductBean.getQuantity());
        productEntity.setCategory(category);
        productEntity.setImages(images);
        productEntity.setCreationDate(LocalDate.now());
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
    public List<ProductEntity> findProductByName(String productName) {
        return productRepository.findProductByName(productName);
    }
}
