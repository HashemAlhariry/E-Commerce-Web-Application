package com.ecommerce.services.impls;

import com.ecommerce.repositories.OrderRepository;
import com.ecommerce.repositories.entites.OrderEntity;
import com.ecommerce.repositories.impl.OrderRepositoryImpl;
import com.ecommerce.services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static final OrderServiceImpl INSTANCE = new OrderServiceImpl();
    private final OrderRepository orderRepository = OrderRepositoryImpl.getInstance();
    private OrderServiceImpl() {
    }

    public static OrderServiceImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public OrderEntity save(OrderEntity entity) {
        return null;
    }

    @Override
    public boolean delete(OrderEntity entity) {
        return false;
    }

    @Override
    public OrderEntity findById(int id) {
        return null;
    }

    @Override
    public List<OrderEntity> findAll() {
        return null;
    }

    @Override
    public OrderEntity update(OrderEntity entity) {
        return null;
    }
}
