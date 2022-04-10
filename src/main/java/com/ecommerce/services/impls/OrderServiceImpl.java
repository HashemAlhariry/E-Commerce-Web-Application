package com.ecommerce.services.impls;

import com.ecommerce.handlers.Connector;
import com.ecommerce.presentation.beans.OrderBean;
import com.ecommerce.presentation.beans.OrderDetailsBean;
import com.ecommerce.repositories.OrderRepository;
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
    private final OrderRepository orderRepository = OrderRepositoryImpl.getInstance();

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
    public boolean submitOrder(OrderBean orderBean, List<OrderDetailsBean> orderDetailsBeanList,String email) {

        try {

            // get user if already registered or create new user
            UserEntity userEntity = getUserByEmail(orderBean,email);

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

                // updating product details quantity and get total purchases number
                productEntity.setQuantity(productEntity.getQuantity()-orderDetailsBean.getQuantity());
                productEntity.setTotalPurchasesNumber(productEntity.getTotalPurchasesNumber()+1);
                ProductRepositoryImpl.getInstance().update(productEntity);
            }

            System.out.println("Order placed");

            return  true;

        }catch (Exception e){
            return  false;
        }


    }


    private UserEntity getUserByEmail(OrderBean orderBean, String email ){

        // get User if logged in or ann user
        List<UserEntity> userEntityListChecker;
        UserEntity userEntity;
        UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();
        userEntityListChecker = userRepository.getUserByEmail(email);

        if(userEntityListChecker.size()==0){
            userEntity =new UserEntity("annonymus",email,"000000",orderBean.getAddress(), LocalDate.now(), Role.CUSTOMER, BigDecimal.valueOf(0));
            userRepository.save(userEntity);
        }else{
            userEntity = userEntityListChecker.get(0);
        }

        return  userEntity;
    }

}
