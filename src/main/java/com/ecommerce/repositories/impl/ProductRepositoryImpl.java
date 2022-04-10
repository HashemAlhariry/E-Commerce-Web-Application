package com.ecommerce.repositories.impl;


import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.ProductEntity;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
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
        return (List<ProductEntity>) entityManager.createNamedQuery("newArrivals").setMaxResults(10).getResultList();
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

//    @Override
//    public int findAllProductsNumber() {
//        Query queryTotal = entityManager.createQuery//                ("Select count(p.id) from ProductEntity p");
//        long countResult = (long)queryTotal.getSingleResult();
//        return (int)countResult;
//    }

//    @Override
//    public List<ProductEntity> getSinglePageProducts(int pageNumber, int recordsPerPage) {
//        Query query = entityManager.createQuery("FROM ProductEntity");
//        query.setFirstResult((pageNumber-1) * recordsPerPage);
//        query.setMaxResults(recordsPerPage);
//        List <ProductEntity> productBeansPerSinglePage = query.getResultList();
//        return productBeansPerSinglePage;
//    }

    public List<ProductEntity> getFilteredProducts(int pageNumber, int recordsPerPage, List<String> categoriesIds){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> criteriaQuery = cb.createQuery(ProductEntity.class);
        Root<ProductEntity> root = criteriaQuery.from(ProductEntity.class);
        criteriaQuery.select(root);
        List<Predicate> predicatesList = new ArrayList<>();
        for (String categoryId : categoriesIds){
            Predicate predicate = cb.equal(root.get("category").get("categoryId"), categoryId);
            predicatesList.add(predicate);
        }
        Predicate[] finalPredicates = new Predicate[predicatesList.size()];
        Predicate predicate = cb.or(predicatesList.toArray(finalPredicates));
        criteriaQuery.where(predicate);
        criteriaQuery.orderBy(cb.desc(root.get("creationDate")));


        List<ProductEntity> result =
                entityManager
                        .createQuery(criteriaQuery)
                        .setMaxResults(recordsPerPage)
                        .setFirstResult((pageNumber-1)*recordsPerPage)
                        .getResultList();

        return result;
    }
    public long countProductsOfCertainCategories(List<String> categoriesIds){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
        Root<ProductEntity> root = criteriaQuery.from(ProductEntity.class);
        criteriaQuery.select(cb.count(root));
        List<Predicate> predicatesList = new ArrayList<>();
        for (String categoryId : categoriesIds){
            Predicate predicate = cb.equal(root.get("category").get("categoryId"), categoryId);
            predicatesList.add(predicate);
        }
        Predicate[] finalPredicates = new Predicate[predicatesList.size()];
        Predicate predicate = cb.or(predicatesList.toArray(finalPredicates));
        criteriaQuery.where(predicate);

        long result =  entityManager.createQuery(criteriaQuery).getSingleResult();
        return result;
    }
}
