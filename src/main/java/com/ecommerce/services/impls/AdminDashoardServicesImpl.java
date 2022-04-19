package com.ecommerce.services.impls;

import com.ecommerce.repositories.StatisticsRepository;
import com.ecommerce.repositories.impl.StatisticsRepositoryImpl;
import com.ecommerce.services.AdminDashoardServices;

public class AdminDashoardServicesImpl implements AdminDashoardServices {


    private final StatisticsRepository statisticsRepository;


    public AdminDashoardServicesImpl(String reqId) {
        this.statisticsRepository = new StatisticsRepositoryImpl(reqId);
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
    public int getAllProducts() {
        return statisticsRepository.getAllProducts();
    }


    @Override
    public int getNewProducts() {
        return statisticsRepository.getNewProduct();
    }

    @Override
    public int getArchivedProduct() {
        return statisticsRepository.getArchivedProduct();
    }

}
