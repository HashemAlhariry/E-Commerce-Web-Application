package com.ecommerce.presentation.beans;

import com.ecommerce.repositories.entites.CartEntity;
import com.ecommerce.repositories.entites.OrderDetailsEntity;
import com.ecommerce.repositories.entites.UserState;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class UserBean {

    private int id;
    private String userName;
    private String email;
    private String pass;
    private String address;
    private LocalDate dateOfBirth;
    private String role;
    private BigDecimal creditLimit;
    private UserState state;
    private Set<CartEntity> cart;
    private Set<OrderDetailsEntity> orderDetails ;

    public UserBean(int id, String userName, String email, String pass, String address, LocalDate dateOfBirth, String role, BigDecimal creditLimit, Set<CartEntity> cart, Set<OrderDetailsEntity> orderDetails) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.pass = pass;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.creditLimit = creditLimit;
        this.cart = cart;
        this.orderDetails = orderDetails;
    }
}
