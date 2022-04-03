package com.ecommerce.services;

import com.ecommerce.repositories.entites.OrderEntity;
import com.ecommerce.repositories.entites.ProductEntity;

import java.util.List;

public interface OrderService {
    OrderEntity save(OrderEntity entity);
    boolean delete(OrderEntity entity);
    OrderEntity findById(int id);
    List<OrderEntity> findAll();
    OrderEntity update(OrderEntity entity);
}
