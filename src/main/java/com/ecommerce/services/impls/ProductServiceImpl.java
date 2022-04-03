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
        for (Long id:ids) {
            ProductEntity productEntity = productRepository.findById(id);
           ProductBean productBean=  ProductMapper.INSTANCE.productEntityToBean(productEntity);
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
            List<ProductEntity> productEntitiesOfSinglePage = productRepository.getSinglePageProducts(pageNumber,countOfProductsPerPage);
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
    public List<ProductEntity> findProductByName(String productName) {return productRepository.findProductByName(productName);}
}
