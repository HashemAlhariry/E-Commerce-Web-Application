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

    @OneToMany(mappedBy = "order")
    private Set<OrderDetailsEntity>orderDetails=new HashSet<>();



}