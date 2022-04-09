package com.ecommerce.presentation.beans;

import com.ecommerce.repositories.entites.OrderDetailsEntity;
import com.ecommerce.repositories.entites.OrderState;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Getter @Setter

public class AdminOrderBean {

    private int id;

    private OrderState state;

    private LocalDateTime dateTime;

    private BigDecimal totalPrice = BigDecimal.ZERO;

    private String phoneNumber;

    private String address;

    private Set<OrderDetailsEntity> orderDetails=new HashSet<>();

    public AdminOrderBean(){}
}
