package com.ecommerce.repositories.impl;


import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.ProductEntity;

public class ProductRepositoryImpl extends RepositoryImpl<ProductEntity,Long> implements ProductRepository {
    private static final ProductRepositoryImpl INSTANCE =new ProductRepositoryImpl();
    private ProductRepositoryImpl(){

    }

    public  static ProductRepositoryImpl getInstance(){
        return INSTANCE;
    }

}
