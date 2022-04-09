package com.ecommerce.presentation.beans;

import com.ecommerce.repositories.entites.OrderDetailsID;
import com.ecommerce.repositories.entites.OrderEntity;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter @Setter
public class AdminOrderDetailsBean {
    private OrderDetailsID id;
    private BigDecimal price = BigDecimal.ZERO;
    private int quantity;
    private UserEntity user;
    private ProductEntity product;
    private OrderEntity order;
    public AdminOrderDetailsBean(){}
}
