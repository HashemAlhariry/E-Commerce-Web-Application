package com.ecommerce.repositories.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter
public class CartID implements Serializable {
    @Column(name = "product_id")
    long productId;
    @Column(name = "user_id")
    int userId;

    public CartID() {
    }

    public CartID(long productId, int userId) {
        this.productId = productId;
        this.userId = userId;
    }
}
