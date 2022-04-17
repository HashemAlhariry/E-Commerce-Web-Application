package com.ecommerce.repositories;

import com.ecommerce.repositories.entites.OrderDetailsEntity;

import java.util.List;

public interface OrderDetailsRepository extends Repository<OrderDetailsEntity, Long> {

    List<OrderDetailsEntity> findAllById(int id);
}
