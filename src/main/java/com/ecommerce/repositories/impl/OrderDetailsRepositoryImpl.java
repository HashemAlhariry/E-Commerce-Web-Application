package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.EntityMangerUtil;
import com.ecommerce.repositories.OrderDetailsRepository;
import com.ecommerce.repositories.entites.OrderDetailsEntity;

public class OrderDetailsRepositoryImpl extends RepositoryImpl<OrderDetailsEntity,Long> implements OrderDetailsRepository {

    public OrderDetailsRepositoryImpl(String entityMangerId) {
        super(EntityMangerUtil.getInstance().getEntityManager(entityMangerId));

    }

}
