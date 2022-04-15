package com.ecommerce.services.impls;

import com.ecommerce.presentation.beans.UserViewBean;
import com.ecommerce.repositories.StatisticsRepository;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.repositories.impl.StatisticsRepositoryImpl;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.services.AdminDashoardServices;
import com.ecommerce.services.UserService;
import com.ecommerce.utils.mappers.UserMapper;

import java.util.List;

public class AdminDashoardServicesImpl implements AdminDashoardServices {


    private static final AdminDashoardServicesImpl INSTANCE = new AdminDashoardServicesImpl();

    private StatisticsRepository statisticsRepository = StatisticsRepositoryImpl.getInstance();



    private AdminDashoardServicesImpl() {

    }

    public static AdminDashoardServicesImpl getInstance() {
        return INSTANCE;
    }


    @Override
    public int getCompletedOrders() {
        return statisticsRepository.getCompletedOrders();
    }

    @Override
    public int getNotCompletedOrders() {
        return statisticsRepository.getNotCompletedOrders();
    }

    @Override
    public int getWaitingOrders() {
        return statisticsRepository.getWaitingOrders();
    }

    @Override
    public int getStatisticsUsers() {
        return statisticsRepository.getStatisticsUsers();
    }

    @Override
    public int getAllProducts () {
        return statisticsRepository.getAllProducts();
    }



}
