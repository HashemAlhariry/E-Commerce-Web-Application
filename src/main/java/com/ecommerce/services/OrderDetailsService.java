package com.ecommerce.services;

import com.ecommerce.repositories.entites.OrderDetailsEntity;
import com.ecommerce.repositories.entites.OrderEntity;

import java.util.List;

public interface OrderDetailsService {

    OrderDetailsEntity save(OrderDetailsEntity entity);
    boolean delete(OrderDetailsEntity entity);
    OrderDetailsEntity findById(int id);
    List<OrderDetailsEntity> findAllById(int id);
    List<OrderDetailsEntity> findAll();
//    OrderEntity update(OrderEntity entity);
}
