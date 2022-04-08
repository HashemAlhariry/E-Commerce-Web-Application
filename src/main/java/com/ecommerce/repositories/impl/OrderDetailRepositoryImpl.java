package com.ecommerce.repositories.impl;

import com.ecommerce.repositories.OrderDetailRepository;
import com.ecommerce.repositories.OrderRepository;
import com.ecommerce.repositories.entites.OrderDetailsEntity;

import java.util.List;

public class OrderDetailRepositoryImpl extends RepositoryImpl<OrderDetailsEntity, Integer> implements OrderDetailRepository {
    private static final OrderDetailRepositoryImpl INSTANCE = new OrderDetailRepositoryImpl();

    private OrderDetailRepositoryImpl() {

    }

    public static OrderDetailRepositoryImpl getInstance() {
        return INSTANCE;
    }


//    @Override
//    public List<OrderDetailsEntity> findById(Integer id) {
//        return (List<OrderDetailsEntity>) entityManager.find(OrderDetailsEntity, id).getResultList();
//    }

}
