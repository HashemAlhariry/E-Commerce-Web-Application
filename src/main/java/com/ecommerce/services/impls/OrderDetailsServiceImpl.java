package com.ecommerce.services.impls;

import com.ecommerce.repositories.OrderDetailRepository;
import com.ecommerce.repositories.OrderRepository;
import com.ecommerce.repositories.entites.OrderDetailsEntity;
import com.ecommerce.repositories.entites.OrderEntity;
import com.ecommerce.repositories.impl.OrderDetailRepositoryImpl;
import com.ecommerce.services.OrderDetailsService;

import java.util.List;

public class OrderDetailsServiceImpl implements OrderDetailsService {

    private static final OrderDetailsServiceImpl INSTANCE = new OrderDetailsServiceImpl();
    private final OrderDetailRepository orderDetailRepository = OrderDetailRepositoryImpl.getInstance();
    private OrderDetailsServiceImpl() {
    }

    public static OrderDetailsServiceImpl getInstance(){
        return INSTANCE;
    }


    @Override
    public OrderDetailsEntity save(OrderDetailsEntity entity) {
        return null;
    }

    @Override
    public boolean delete(OrderDetailsEntity entity) {
        return false;
    }

    @Override
    public OrderDetailsEntity findById(int id) {
        return null;
    }

    @Override
    public List<OrderDetailsEntity> findAllById(int id) {
        return orderDetailRepository.findAllById(id);
    }

    @Override
    public List<OrderDetailsEntity> findAll() {
        return null;
    }
}
