package com.ecommerce.services;

import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity save(ProductEntity entity);
    boolean delete(ProductEntity entity);
    ProductEntity findById(Long id);
    List<ProductEntity> findAll();
    ProductEntity update(ProductEntity entity);
    List<ProductEntity>getLast10();
    List<ProductEntity> findAllByCategoryId(int id);
    List<ProductBean> getAllProductBeans(List<Long> ids);
    List<ProductBean> getProductsOfPage(int pageNumber);
    int getAllProductsCount();
    List<ProductEntity> findProductByName(String productName);

}
