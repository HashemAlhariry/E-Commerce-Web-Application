package com.ecommerce.repositories.impl;


import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.ProductRepository;
import java.util.List;

public enum ProductRepositoryImpl implements ProductRepository {

    Instance;

    public void insertProduct(ProductBean productBean){
    }

    @Override
    public List<ProductBean> getAllProduct() {

       
        return null;

    }
}
