package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter
public class OrderBean {

    private String address;
    private Date dateTime;
    private String phoneNumber;
    private int state;
    private BigDecimal totalPrice;

    public OrderBean(String address, Date dateTime, String phoneNumber, int state, BigDecimal totalPrice) {
        this.address = address;
        this.dateTime = dateTime;
        this.phoneNumber = phoneNumber;
        this.state = state;
        this.totalPrice = totalPrice;
    }

}
