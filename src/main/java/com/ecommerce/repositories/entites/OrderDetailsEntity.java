package com.ecommerce.repositories.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "order_details")

@NamedQueries({
        @NamedQuery(name = "findAllById",query = "select o from OrderDetailsEntity  o   where  o.id.orderId = :order_id")

})

@Getter
@Setter
public class OrderDetailsEntity implements Serializable {
    @EmbeddedId
    private OrderDetailsID id;

    private BigDecimal price = BigDecimal.ZERO;

    private int quantity;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public OrderDetailsEntity(){

    }

    public OrderDetailsEntity(BigDecimal price, int quantity, UserEntity user, ProductEntity product, OrderEntity order,OrderDetailsID id) {
        this.price = price;
        this.quantity = quantity;
        this.user = user;
        this.product = product;
        this.order = order;
        this.id=id;
    }


}
