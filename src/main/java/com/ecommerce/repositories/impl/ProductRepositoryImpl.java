package com.ecommerce.repositories.impl;


import com.ecommerce.handlers.EntityMangerUtil;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.ProductState;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl extends RepositoryImpl<ProductEntity, Long> implements ProductRepository {
    public ProductRepositoryImpl(String entityMangerId) {
        super(EntityMangerUtil.getInstance().getEntityManager(entityMangerId));

    }

    @Override
    public List<ProductEntity> getLast10() {
        return (List<ProductEntity>) entityManager.createNamedQuery("newArrivals").setMaxResults(10).getResultList();
    }

    @Override
    public List<ProductEntity> findAllByCategoryId(int id) {

        TypedQuery<ProductEntity> query = entityManager.createNamedQuery("findAllByCategoryId", ProductEntity.class);
        query.setParameter("category_id", id);
        return query.getResultList();
    }

    @Override
    public List<ProductEntity> findProductByName(String productName) {
        TypedQuery<ProductEntity> query = entityManager.createNamedQuery("findProductByName", ProductEntity.class);
        query.setParameter("product_name", productName);
        return query.getResultList();
    }

    @Override
    public List<ProductEntity> findProductByPrice(BigDecimal productPrice) {
        TypedQuery<ProductEntity> query = entityManager.createNamedQuery("findProductByPrice", ProductEntity.class);
        query.setParameter("product_price", productPrice);
        return query.getResultList();

    }

    @Override
    public List<ProductEntity> findProductByPriceAndCategoryId(BigDecimal productPrice, int id) {
        TypedQuery<ProductEntity> query = entityManager.createNamedQuery("findProductByPriceAndCategoryId", ProductEntity.class);
        query.setParameter("product_price", productPrice);
        query.setParameter("category_id", id);
        return query.getResultList();
    }

    @Override
    public boolean delete(ProductEntity entity) {
        entity.setState(ProductState.ARCHIVED);
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return true;
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

    public List<ProductEntity> getFilteredProducts(int pageNumber, int recordsPerPage, List<String> categoriesIds) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> criteriaQuery = cb.createQuery(ProductEntity.class);
        Root<ProductEntity> root = criteriaQuery.from(ProductEntity.class);
        criteriaQuery.select(root);
        List<Predicate> predicatesList = new ArrayList<>();
        for (String categoryId : categoriesIds) {
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
                        .setFirstResult((pageNumber - 1) * recordsPerPage)
                        .getResultList();

        return result;
    }

    public long countProductsOfCertainCategories(List<String> categoriesIds) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
        Root<ProductEntity> root = criteriaQuery.from(ProductEntity.class);
        criteriaQuery.select(cb.count(root));
        List<Predicate> predicatesList = new ArrayList<>();
        for (String categoryId : categoriesIds) {
            Predicate predicate = cb.equal(root.get("category").get("categoryId"), categoryId);
            predicatesList.add(predicate);
        }
        Predicate[] finalPredicates = new Predicate[predicatesList.size()];
        Predicate predicate = cb.or(predicatesList.toArray(finalPredicates));
        criteriaQuery.where(predicate);

        long result = entityManager.createQuery(criteriaQuery).getSingleResult();
        return result;
    }

    @Override
    public List<ProductEntity> relatedProducts(int id) {
        TypedQuery<ProductEntity> query = entityManager.createNamedQuery("relatedProducts", ProductEntity.class);
        query.setParameter("category_id", id);
        return query.setMaxResults(4).getResultList();
    }
}
