package com.ecommerce.services.impls;


import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;
import com.ecommerce.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private  final ProductRepository productRepository= ProductRepositoryImpl.getInstance();

    @Override
    public ProductEntity save(ProductEntity entity) {
        return null;
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
        return null;
    }

    @Override
    public ProductEntity update(ProductEntity entity) {
        return null;
    }
}
