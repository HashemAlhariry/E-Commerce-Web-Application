package com.ecommerce.services;

import com.ecommerce.presentation.beans.OrderBean;
import com.ecommerce.presentation.beans.OrderDetailsBean;

import java.util.List;

public interface OrderService {

    public boolean submitOrder(OrderBean orderBean, List<OrderDetailsBean> orderDetailsBeanList);
}
