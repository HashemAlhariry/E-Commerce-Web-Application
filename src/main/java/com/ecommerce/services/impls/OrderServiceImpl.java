package com.ecommerce.services.impls;

import com.ecommerce.presentation.beans.OrderBean;
import com.ecommerce.presentation.beans.OrderDetailsBean;
import com.ecommerce.services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderServiceImpl(){}
    private static final OrderServiceImpl INSTANCE = new OrderServiceImpl();
    public static OrderServiceImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean submitOrder(OrderBean orderBean, List<OrderDetailsBean> orderDetailsBeanList) {

        // add order bean



        // add all order details bean in database

        return  false;
    }


}
