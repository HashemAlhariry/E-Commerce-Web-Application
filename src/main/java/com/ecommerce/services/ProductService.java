package com.ecommerce.services;

import com.ecommerce.exceptions.CustomValidationException;
import com.ecommerce.presentation.beans.AddProductBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.ProductEntity;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    ProductEntity save(AddProductBean addProductBean) throws IOException, CustomValidationException;
    boolean delete(ProductEntity entity);
    ProductEntity findById(Long id);
    List<ProductEntity> findAll();
    ProductEntity update(ProductEntity entity);
    List<ProductEntity>getLast10();
    List<ProductEntity> findAllByCategoryId(int id);
    List<ProductBean> getAllProductBeans(List<Long> ids);

    List<ProductEntity> findProductByName(String productName);

}
