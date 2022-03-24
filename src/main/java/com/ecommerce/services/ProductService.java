package com.ecommerce.services;

import com.ecommerce.repositories.entites.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity save(ProductEntity entity);
    boolean delete(ProductEntity entity);
    ProductEntity findById(Long id);
    List<ProductEntity> findAll();
    ProductEntity update(ProductEntity entity);

    List<ProductEntity>getLast10();
}
