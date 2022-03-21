package com.ecommerce.repository.impl;


import com.ecommerce.dto.ProductDto;
import com.ecommerce.repository.ProductRepository;
import java.util.List;

public enum ProductRepositoryImpl implements ProductRepository {

    Instance;

    public void insertProduct(ProductDto productDto){
    }

    @Override
    public List<ProductDto> getAllProduct() {

       
        return null;

    }
}
