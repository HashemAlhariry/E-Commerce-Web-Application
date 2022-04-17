package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.EntityMangerUtil;
import com.ecommerce.repositories.OrderDetailRepository;
import com.ecommerce.repositories.entites.OrderDetailsEntity;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class OrderDetailRepositoryImpl extends RepositoryImpl<OrderDetailsEntity, Integer> implements OrderDetailRepository {
    public OrderDetailRepositoryImpl(String entityMangerId) {
        super(EntityMangerUtil.getInstance().getEntityManager(entityMangerId));

    }

    @Override
    public List<OrderDetailsEntity> findAllById(int id) {
        TypedQuery<OrderDetailsEntity> query = entityManager.createNamedQuery("findAllById" , OrderDetailsEntity.class);
        query.setParameter("order_id", id);
        return  query.getResultList();
    }

//    @Override
//    public List<OrderDetailsEntity> findByOrderId(int id) {
//        return null;
//    }


//    @Override
//    public List<OrderDetailsEntity> findById(Integer id) {
//        return (List<OrderDetailsEntity>) entityManager.find(OrderDetailsEntity, id).getResultList();
//    }

}
