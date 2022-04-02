package com.ecommerce.repositories.impl;

import com.ecommerce.repositories.OrderDetailsRepository;
import com.ecommerce.repositories.entites.OrderDetailsEntity;

public class OrderDetailsRepositoryImpl extends RepositoryImpl<OrderDetailsEntity,Long> implements OrderDetailsRepository {

    private static final OrderDetailsRepositoryImpl INSTANCE = new OrderDetailsRepositoryImpl();
    private OrderDetailsRepositoryImpl() {

    }
    public static OrderDetailsRepositoryImpl getInstance() {
        return INSTANCE;
    }

}
