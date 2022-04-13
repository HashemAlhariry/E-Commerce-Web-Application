package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.Connector;
import com.ecommerce.repositories.StatisticsRepository;
import com.ecommerce.repositories.entites.OrderEntity;
import com.ecommerce.repositories.entites.OrderState;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


import java.util.List;

public class StatisticsRepositoryImpl implements StatisticsRepository {

    private static final StatisticsRepositoryImpl INSTANCE = new StatisticsRepositoryImpl();
    protected final EntityManager entityManager = Connector.getInstance().getEntityManager();

    private StatisticsRepositoryImpl() {

    }

    public static StatisticsRepositoryImpl getInstance() {
        return INSTANCE;
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

        Query query = entityManager.createNamedQuery("orders.completedOrder");
        List<ProductEntity> resultList = query.getResultList();
        System.out.println(resultList.size());
        return resultList.size();

    }

    @Override
    public int getNotCompletedOrders() {

        Query query = entityManager.createNamedQuery("orders.notCompletedOrder");
        List<ProductEntity> resultList = query.getResultList();
        System.out.println(resultList.size());
        return resultList.size();

    }


    @Override
    public int getWaitingOrders() {
        Query query = entityManager.createNamedQuery("orders.pending");
        List<ProductEntity> resultList = query.getResultList();
        System.out.println(resultList.size());
        return resultList.size();
    }



}
