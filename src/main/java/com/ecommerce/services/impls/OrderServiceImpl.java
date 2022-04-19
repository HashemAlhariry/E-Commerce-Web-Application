package com.ecommerce.services.impls;

import com.ecommerce.handlers.Connector;
import com.ecommerce.presentation.beans.OrderBean;
import com.ecommerce.presentation.beans.OrderDetailsBean;
import com.ecommerce.presentation.beans.OrderHistoryBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.OrderDetailsRepository;
import com.ecommerce.repositories.OrderRepository;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.*;
import com.ecommerce.repositories.impl.OrderDetailsRepositoryImpl;
import com.ecommerce.repositories.impl.OrderRepositoryImpl;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.services.OrderService;
import com.ecommerce.utils.mappers.OrderMapper;
import com.ecommerce.utils.mappers.ProductMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;



    public OrderServiceImpl(String reqId) {
        orderRepository = new OrderRepositoryImpl(reqId);
        orderDetailsRepository = new OrderDetailsRepositoryImpl(reqId);
        productRepository = new ProductRepositoryImpl(reqId);
        userRepository = new UserRepositoryImpl(reqId);
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
        return orderRepository.findById(id);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderEntity> findAllByUserId(int userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public OrderEntity update(OrderEntity entity) {
        return null;
    }

    // update here
    @Override
    public boolean submitOrder(OrderBean orderBean, List<OrderDetailsBean> orderDetailsBeanList, String email) {

        try {

            // get user if already registered or create new user
            UserEntity userEntity = getUserByEmail(orderBean, email);

            // get Order Entity
            OrderEntity orderEntity = OrderMapper.INSTANCE.OrderBeanToEntity(orderBean);
            orderEntity.setState(OrderState.PROCESSING);

            orderRepository.save(orderEntity);


            // get all order details entity
            for (OrderDetailsBean orderDetailsBean : orderDetailsBeanList) {

                OrderDetailsID orderDetailsId = new OrderDetailsID((int) orderDetailsBean.getProduct().getId(), userEntity.getId(), orderEntity.getId());

                //Map product bean to product entity
                ProductEntity productEntity = productRepository.findById(orderDetailsBean.getProduct().getId());

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

                // updating product details quantity and get total purchases number


                productEntity.setQuantity(productEntity.getQuantity() - orderDetailsBean.getQuantity());
                productEntity.setTotalPurchasesNumber(productEntity.getTotalPurchasesNumber() + 1);
                if(productEntity.getQuantity()==0){
                    productEntity.setState(ProductState.OUT_OF_STOCK);
                }

                productRepository.update(productEntity);
            }

            System.out.println("Order placed");

            return true;

        } catch (Exception e) {
            return false;
        }


    }

    private UserEntity getUserByEmail(OrderBean orderBean, String email) {

        // get User if logged in or ann user
        List<UserEntity> userEntityListChecker;
        UserEntity userEntity;
        userEntityListChecker = userRepository.getUserByEmail(email);

        if (userEntityListChecker.size() == 0) {
            userEntity = new UserEntity("annonymus", email, "000000", orderBean.getAddress(), LocalDate.now(), Role.CUSTOMER, BigDecimal.valueOf(0));
            userRepository.save(userEntity);
        } else {
            userEntity = userEntityListChecker.get(0);
        }

        return userEntity;
    }

    public List<OrderHistoryBean> getUserOrderHistory(String userEmail){

        List<OrderEntity> orderEntityList = orderRepository.getAllUserOrder(userEmail);
        List<OrderHistoryBean> orderHistoryBeans = new ArrayList<>();

        for (OrderEntity orderEntity: orderEntityList) {

            // get all products attached with order
            List<OrderDetailsEntity>  orderDetailsEntityList = orderDetailsRepository.findAllById(orderEntity.getId());

            List<OrderDetailsBean> orderDetailsBeanList = mapOrderDetailsEntityToOrderDetailsBean(orderDetailsEntityList);

            OrderHistoryBean orderHistoryBean = new OrderHistoryBean(
                    orderEntity.getId(),
                    orderEntity.getAddress(),
                    orderEntity.getDateTime(),
                    orderEntity.getPhoneNumber(),
                    orderEntity.getState(),
                    orderEntity.getTotalPrice(),
                    orderEntity.getEmail(),
                    orderDetailsBeanList);


            // add order details with order entity into order history beans
            orderHistoryBeans.add(orderHistoryBean);

        }

        return orderHistoryBeans;
    }

    private List<OrderDetailsBean> mapOrderDetailsEntityToOrderDetailsBean(List<OrderDetailsEntity> orderDetailsEntityList){

        //(int orderId, ProductBean product, int userId, BigDecimal price, int quantity)

        List<OrderDetailsBean> orderDetailsBeanList = new ArrayList<>();
        for (OrderDetailsEntity orderDetailsEntity: orderDetailsEntityList) {
            ProductBean productBean = ProductMapper.INSTANCE.productEntityToBean(orderDetailsEntity.getProduct());
            orderDetailsBeanList.add(new OrderDetailsBean(orderDetailsEntity.getId().getOrderId(),
                    productBean,
                    orderDetailsEntity.getId().getUserId(),
                    orderDetailsEntity.getPrice(),
                    orderDetailsEntity.getQuantity()));

        }
        return  orderDetailsBeanList;
    }


}
