package com.ecommerce.repositories;

public interface StatisticsRepository {

        int getNotCompletedOrders();
        int getCompletedOrders();
        int getWaitingOrders();
        int getStatisticsUsers();
        int getAllProducts();


}
