package com.ecommerce.repositories.impl;


import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.ProductEntity;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
    public int findAllProductsNumber() {
        Query queryTotal = entityManager.createQuery
                ("Select count(p.id) from ProductEntity p");
        long countResult = (long)queryTotal.getSingleResult();
        return (int)countResult;
    }

    @Override
    public List<ProductEntity> getSinglePageProducts(int pageNumber, int recordsPerPage) {
        Query query = entityManager.createQuery("FROM ProductEntity");
        query.setFirstResult((pageNumber-1) * recordsPerPage);
        query.setMaxResults(recordsPerPage);
        List <ProductEntity> productBeansPerSinglePage = query.getResultList();
        return productBeansPerSinglePage;
    }
}
