package com.ecommerce.services;

import com.ecommerce.presentation.beans.OrderBean;
import com.ecommerce.presentation.beans.OrderDetailsBean;
import com.ecommerce.presentation.beans.OrderHistoryBean;
import com.ecommerce.repositories.entites.OrderEntity;

import java.util.List;

public interface OrderService {
    OrderEntity save(OrderEntity entity);
    boolean delete(OrderEntity entity);
    OrderEntity findById(int id);
    List<OrderEntity> findAll();
    List<OrderEntity> findAllByUserId(int userId);
    OrderEntity update(OrderEntity entity);

     boolean submitOrder(OrderBean orderBean, List<OrderDetailsBean> orderDetailsBeanList,String email);

     List<OrderHistoryBean> getUserOrderHistory(String userEmail);

}
