package com.ecommerce.services.impls;


import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;
import com.ecommerce.services.ProductService;
import com.ecommerce.utils.mappers.ProductMapper;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static final ProductServiceImpl INSTANCE = new ProductServiceImpl();
    private final ProductRepository productRepository = ProductRepositoryImpl.getInstance();

    private ProductServiceImpl() {
    }

    public static ProductServiceImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public ProductEntity save(ProductEntity entity) {
        return null;
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
        System.out.println("inside th repo"); return productRepository.update(entity);
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
        for (Long id:ids) {
            ProductEntity productEntity = productRepository.findById(id);
           ProductBean productBean=  ProductMapper.INSTANCE.productEntityToBean(productEntity);
           productBeans.add(productBean);
        }
        return productBeans;
    }


    @Override
    public List<ProductEntity> findProductByName(String productName) {return productRepository.findProductByName(productName);}
}
