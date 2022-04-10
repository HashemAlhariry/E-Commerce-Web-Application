package com.ecommerce.repositories.impl;

import com.ecommerce.repositories.OrderRepository;
import com.ecommerce.repositories.entites.OrderEntity;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class OrderRepositoryImpl extends RepositoryImpl<OrderEntity, Integer> implements OrderRepository {
    private static final OrderRepositoryImpl INSTANCE = new OrderRepositoryImpl();

    private OrderRepositoryImpl() {

    }

    public static OrderRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<OrderEntity> findAllByUserId(int userId) {
        TypedQuery<OrderEntity> query = entityManager.createNamedQuery("findAllByUserId", OrderEntity.class);
        query.setParameter("user_id", userId);
        return  query.getResultList();
    }
}
