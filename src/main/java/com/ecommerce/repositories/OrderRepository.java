package com.ecommerce.repositories;

import com.ecommerce.repositories.entites.OrderEntity;

import java.util.List;

public interface OrderRepository extends Repository<OrderEntity,Integer> {
    List<OrderEntity> findAllByUserId(int userId);

    List<OrderEntity> getAllUserOrder(String email);
}
