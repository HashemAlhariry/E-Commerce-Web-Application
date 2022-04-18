package com.ecommerce.repositories.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")

@NamedQueries({
        @NamedQuery(name = "user.findByEmail", query = "SELECT u from UserEntity u where u.email=:email"),
        @NamedQuery(name = "user.findById", query = "select u from UserEntity u where  u.id = :id")

})

@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String userName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String pass;
    @Column(nullable = false)
    private String address;
    private LocalDate dateOfBirth;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;
    @Column(nullable = false)
    private BigDecimal creditLimit = new BigDecimal(0);
    private UserState state;
    @OneToMany(mappedBy = "user")
    private Set<CartEntity> cart;

    @OneToMany(mappedBy = "user")
    private Set<OrderDetailsEntity> orderDetails = new HashSet<>();

    public UserEntity() {

    }

    public UserEntity(String userName, String email, String pass, String address, LocalDate dateOfBirth, Role role, BigDecimal creditLimit) {
        this.userName = userName;
        this.email = email;
        this.pass = pass;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
