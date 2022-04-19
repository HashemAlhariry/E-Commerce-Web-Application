package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.EntityMangerUtil;
import com.ecommerce.repositories.StatisticsRepository;
import com.ecommerce.repositories.entites.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class StatisticsRepositoryImpl implements StatisticsRepository {

    protected final EntityManager entityManager;

    public StatisticsRepositoryImpl(String entityMangerId) {
        this.entityManager = EntityMangerUtil.getInstance().getEntityManager(entityMangerId);

    }


    @Override
    public int getStatisticsUsers() {
        Query query = entityManager.createQuery(" SELECT u FROM UserEntity u");
        List<UserEntity> resultList = query.getResultList();
        System.out.println(resultList.size());
        return resultList.size();

    }

    @Override
    public int getAllProducts() {
        Query query = entityManager.createQuery("SELECT p FROM ProductEntity p");
        List<ProductEntity> resultList = query.getResultList();
        System.out.println(resultList.size());
        return resultList.size();

    }


    @Override
    public int getCompletedOrders() {
        List<OrderEntity> resultList = entityManager.createQuery("SELECT o FROM OrderEntity o").getResultList();
        int counter = 0;
        if (!resultList.isEmpty()) {
            for (OrderEntity order : resultList) {
                if (order.getState().equals(OrderState.ARRIVED))
                    counter++;
            }

        }
        return counter;
    }


    @Override
    public int getNotCompletedOrders() {
        List<OrderEntity> resultList = entityManager.createQuery("SELECT o FROM OrderEntity o").getResultList();
        int counter = 0;
        if (!resultList.isEmpty()) {
            for (OrderEntity order : resultList) {
                if (order.getState().equals(OrderState.CANCELLED))
                    counter++;
            }

        }
        return counter;
    }


    @Override
    public int getWaitingOrders() {
        List<OrderEntity> resultList = entityManager.createQuery("SELECT o FROM OrderEntity o").getResultList();
        int counter = 0;
        if (!resultList.isEmpty()) {
            for (OrderEntity order : resultList) {
                if (order.getState().equals(OrderState.PENDING))
                    counter++;
            }

        }
        return counter;
    }

    @Override
    public int getNewProduct() {
        List<ProductEntity> resultList = entityManager.createQuery("SELECT o FROM ProductEntity o").getResultList();
        int counter = 0;
        if (!resultList.isEmpty()) {
            for (ProductEntity product : resultList) {
                if (product.getState().equals(ProductState.NEW))
                    counter++;
            }

        }
        return counter;
    }

    @Override
    public int getArchivedProduct() {
        List<ProductEntity> resultList = entityManager.createQuery("SELECT o FROM ProductEntity o").getResultList();
        int counter = 0;
        if (!resultList.isEmpty()) {
            for (ProductEntity product : resultList) {
                if (product.getState().equals(ProductState.OUT_OF_STOCK))
                    counter++;
            }

        }
        return counter;
    }


}
