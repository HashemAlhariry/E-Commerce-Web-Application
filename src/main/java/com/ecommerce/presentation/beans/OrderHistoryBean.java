package com.ecommerce.presentation.beans;

import com.ecommerce.repositories.entites.OrderState;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderHistoryBean {

    private int orderId;
    private String address;
    private LocalDateTime dateTime;
    private String phoneNumber;
    private OrderState state;
    private BigDecimal totalPrice;
    private String email;
    private List<OrderDetailsBean> orderDetailsBeanList;

    public OrderHistoryBean(int orderId,String address, LocalDateTime dateTime, String phoneNumber, OrderState state, BigDecimal totalPrice, String email, List<OrderDetailsBean> orderDetailsBeanList) {
        this.orderId=orderId;
        this.address = address;
        this.dateTime = dateTime;
        this.phoneNumber = phoneNumber;
        this.state = state;
        this.totalPrice = totalPrice;
        this.email = email;
        this.orderDetailsBeanList = orderDetailsBeanList;
    }
}
