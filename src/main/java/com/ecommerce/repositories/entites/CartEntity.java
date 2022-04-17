package com.ecommerce.repositories.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart")
@Getter @Setter
public class CartEntity {
    @EmbeddedId
    private CartID id;

    private int quantity;

    public CartEntity(){}

    public CartEntity(UserEntity userEntity, ProductEntity productEntity, int quantity){
        this.product = productEntity;
        this.user = userEntity;
        this.quantity = quantity;
    }

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}
