package com.ecommerce.repositories.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter
public class OrderDetailsID implements Serializable {

    @Column(name = "product_id")
    long productId;
    @Column(name = "user_id")
    int userId;
    @Column(name = "order_id")
    int orderId;

    public  OrderDetailsID(){

    }

    public OrderDetailsID(int productId, int userId, int orderId) {
        this.productId = productId;
        this.userId = userId;
        this.orderId = orderId;
    }
}
