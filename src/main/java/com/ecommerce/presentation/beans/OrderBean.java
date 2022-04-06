package com.ecommerce.presentation.beans;

import com.ecommerce.repositories.entites.OrderState;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter
public class OrderBean {

    private String address;
    private Date dateTime;
    private String phoneNumber;
    private OrderState state;
    private BigDecimal totalPrice;
    private String email;

    public OrderBean(String address, Date dateTime, String phoneNumber, OrderState state, BigDecimal totalPrice,String email) {
        this.address = address;
        this.dateTime = dateTime;
        this.phoneNumber = phoneNumber;
        this.state = state;
        this.totalPrice = totalPrice;
        this.email=email;
    }

}
