package com.ecommerce.repositories.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "findAllByUserId",
                query = "select  o from OrderEntity o join o.orderDetails od where  od.user.id=:user_id"),

        @NamedQuery(name = "orders.completedOrder",
                query = "SELECT COUNT(o.id) from OrderEntity  o where o.state = com.ecommerce.repositories.entites.OrderState.ARRIVED"),

        @NamedQuery(name = "orders.pending",
                query = "SELECT COUNT(o.id) from OrderEntity  o where o.state = com.ecommerce.repositories.entites.OrderState.PENDING"),

        @NamedQuery(name = "orders.notCompletedOrder",
                query = "SELECT COUNT(o.id) from OrderEntity  o where o.state = com.ecommerce.repositories.entites.OrderState.CANCELLED"),

})

public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    private LocalDateTime dateTime;

    private BigDecimal totalPrice = BigDecimal.ZERO;

    private String phoneNumber;

    private String address;

    private String email;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetailsEntity> orderDetails = new HashSet<>();

    public OrderEntity(OrderState state, LocalDateTime dateTime, BigDecimal totalPrice, String phoneNumber, String address, Set<OrderDetailsEntity> orderDetails) {
        this.state = state;
        this.dateTime = dateTime;
        this.totalPrice = totalPrice;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderDetails = orderDetails;
    }

    public OrderEntity() {

    }
}
