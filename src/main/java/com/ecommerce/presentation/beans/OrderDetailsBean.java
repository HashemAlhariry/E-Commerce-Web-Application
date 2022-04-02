package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class OrderDetailsBean {

    private int orderId;
    private int productId;
    private int userId;
    private BigDecimal price;
    private int quantity;

    public OrderDetailsBean(int orderId, int productId, int userId, BigDecimal price, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.userId = userId;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetailsBean(int productId, int userId, BigDecimal price, int quantity) {
        this.productId = productId;
        this.userId = userId;
        this.price = price;
        this.quantity = quantity;
    }
}
