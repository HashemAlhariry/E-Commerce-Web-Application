package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class StatisticsBean {

    private int completedOrders;
    private int notCompletedOrders;
    private int waitingOrder;
    private int statisticsUsers;
    private int allProducts;


    public StatisticsBean ( int completedOrders, int notCompletedOrders, int waitingOrder, int statisticsUsers, int allProducts) {
        this.completedOrders = completedOrders;
        this.notCompletedOrders = notCompletedOrders;
        this.waitingOrder = waitingOrder;
        this.statisticsUsers = statisticsUsers;
        this.allProducts = allProducts;
    }



    public StatisticsBean() {

    }

    @Override
    public String toString() {
        return "StatisticsBean{" +
                "completedOrders=" + completedOrders +
                ", notCompletedOrders=" + notCompletedOrders +
                ", waitingOrder=" + waitingOrder +
                ", statisticsUsers=" + statisticsUsers +
                ", allProducts=" + allProducts +
                '}';
    }
}

