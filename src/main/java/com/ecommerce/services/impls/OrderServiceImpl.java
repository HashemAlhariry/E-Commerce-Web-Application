package com.ecommerce.services.impls;

import com.ecommerce.handlers.Connector;
import com.ecommerce.presentation.beans.OrderBean;
import com.ecommerce.presentation.beans.OrderDetailsBean;
import com.ecommerce.repositories.entites.*;
import com.ecommerce.repositories.impl.OrderDetailsRepositoryImpl;
import com.ecommerce.repositories.impl.OrderRepositoryImpl;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.services.OrderService;
import com.ecommerce.utils.mappers.OrderMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderServiceImpl(){}
    private static final OrderServiceImpl INSTANCE = new OrderServiceImpl();
    public static OrderServiceImpl getInstance(){
        return INSTANCE;
    }


    // update here
    @Override
    public boolean submitOrder(OrderBean orderBean, List<OrderDetailsBean> orderDetailsBeanList) {

        try {

            // get User if logged in or ann user
            UserEntity userEntity =new UserEntity("annonymus","empty5","empty6",orderBean.getAddress(), LocalDate.now(), Role.CUSTOMER, BigDecimal.valueOf(0));
            UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();
            userRepository.save(userEntity);

            // get Order Entity
            OrderEntity orderEntity = OrderMapper.INSTANCE.OrderBeanToEntity(orderBean);
            orderEntity.setState(OrderState.PROCESSING);

            OrderRepositoryImpl orderRepository = OrderRepositoryImpl.getInstance();
            orderRepository.save(orderEntity);



            OrderDetailsRepositoryImpl orderDetailsRepository = OrderDetailsRepositoryImpl.getInstance();
            // get all order details entity
            for (OrderDetailsBean orderDetailsBean: orderDetailsBeanList) {

                OrderDetailsID orderDetailsId = new OrderDetailsID((int) orderDetailsBean.getProduct().getId(),userEntity.getId(),orderEntity.getId());

                //Map product bean to product entity
                ProductEntity productEntity = ProductRepositoryImpl.getInstance().findById(orderDetailsBean.getProduct().getId());

                Connector.getInstance().getEntityManager().merge(productEntity);

                OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity(
                        orderDetailsBean.getPrice(),
                        orderDetailsBean.getQuantity(),
                        userEntity,
                        productEntity,
                        orderEntity,
                        orderDetailsId
                        );

                orderDetailsRepository.save(orderDetailsEntity);

                productEntity.setQuantity(productEntity.getQuantity()-orderDetailsBean.getQuantity());
                ProductRepositoryImpl.getInstance().update(productEntity);
            }

            System.out.println("Order placed");

            return  true;

        }catch (Exception e){
            return  false;
        }


    }



}
