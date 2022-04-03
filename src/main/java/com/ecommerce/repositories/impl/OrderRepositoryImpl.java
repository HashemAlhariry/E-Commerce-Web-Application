package com.ecommerce.repositories.impl;

import com.ecommerce.repositories.OrderRepository;
import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.repositories.entites.OrderEntity;

public class OrderRepositoryImpl extends RepositoryImpl<OrderEntity, Integer> implements OrderRepository {
    private static final OrderRepositoryImpl INSTANCE = new OrderRepositoryImpl();

    private OrderRepositoryImpl() {

    }

    public static OrderRepositoryImpl getInstance() {
        return INSTANCE;
    }
}
