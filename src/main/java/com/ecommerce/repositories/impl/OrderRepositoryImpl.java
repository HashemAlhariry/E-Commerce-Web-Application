package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.EntityMangerUtil;
import com.ecommerce.repositories.OrderRepository;
import com.ecommerce.repositories.entites.OrderEntity;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class OrderRepositoryImpl extends RepositoryImpl<OrderEntity, Integer> implements OrderRepository {
    public OrderRepositoryImpl(String entityMangerId) {
        super(EntityMangerUtil.getInstance().getEntityManager(entityMangerId));

    }

    @Override
    public List<OrderEntity> findAllByUserId(int userId) {
        TypedQuery<OrderEntity> query = entityManager.createNamedQuery("findAllByUserId", OrderEntity.class);
        query.setParameter("user_id", userId);
        return  query.getResultList();
    }

    @Override
    public List<OrderEntity> getAllUserOrder(String email) {
        Query queryTotal = entityManager.createQuery("Select p from OrderEntity p where p.email=  " +  "'" + email +"'" );
        List<OrderEntity> orderEntityList = queryTotal.getResultList();
        return orderEntityList;
    }
}
