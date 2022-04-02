package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class OrderDetailsBean {

    private int orderId;
    private ProductBean product;
    private int userId;
    private BigDecimal price;
    private int quantity;

    public OrderDetailsBean(int orderId, ProductBean product, int userId, BigDecimal price, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.userId = userId;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetailsBean(ProductBean product, int userId, BigDecimal price, int quantity) {
        this.product = product;
        this.userId = userId;
        this.price = price;
        this.quantity = quantity;
    }
}
