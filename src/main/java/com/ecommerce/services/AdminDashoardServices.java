package com.ecommerce.services;

public interface AdminDashoardServices {

    int getCompletedOrders();
    int getNotCompletedOrders();
    int getWaitingOrders();
    int getStatisticsUsers();
    int getAllProducts ();
    int getNewProducts();
    int getArchivedProduct();


}
