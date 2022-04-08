package com.ecommerce.repositories.impl;


import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.ProductEntity;

import com.ecommerce.repositories.entites.ProductState;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.util.List;

public class ProductRepositoryImpl extends RepositoryImpl<ProductEntity, Long> implements ProductRepository {
    private static final ProductRepositoryImpl INSTANCE = new ProductRepositoryImpl();

    private ProductRepositoryImpl() {

    }

    public static ProductRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<ProductEntity> getLast10() {
        return (List<ProductEntity>) entityManager.createNamedQuery("reversed ids").setMaxResults(10).getResultList();
    }

    @Override
    public List<ProductEntity> findAllByCategoryId(int id) {
        TypedQuery<ProductEntity> query = entityManager.createNamedQuery("findAllByCategoryId", ProductEntity.class);
        query.setParameter("category_id", id);
        return  query.getResultList();
    }

    @Override
    public List<ProductEntity> findProductByName(String productName) {
        TypedQuery<ProductEntity> query = entityManager.createNamedQuery("findProductByName" , ProductEntity.class);
        query.setParameter("product_name", productName);
        return  query.getResultList();
    }

    @Override
    public List<ProductEntity> findProductByPrice(BigDecimal productPrice) {
        TypedQuery<ProductEntity> query = entityManager.createNamedQuery("findProductByPrice" , ProductEntity.class);
        query.setParameter("product_price", productPrice);
        return  query.getResultList();

    }

    @Override
    public boolean delete(ProductEntity entity) {
        entity.setState(ProductState.ARCHIVED);
        entityManager.getTransaction().begin();
        entity=entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return true;
    }

}
