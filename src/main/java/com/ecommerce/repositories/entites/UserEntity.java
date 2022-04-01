package com.ecommerce.repositories.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "user")
@Getter @Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String userName;
    @Column(unique = true , nullable = false)
    private String email;
    @Column(nullable = false)
    private String pass;
    @Column(nullable = false)
    private String address;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;
    @Column(nullable = false)
    private BigDecimal creditLimit= new BigDecimal(0);

    public UserEntity(){

    }

    public UserEntity(String userName, String email, String pass, String address, Date dateOfBirth, Role role, BigDecimal creditLimit) {
        this.userName = userName;
        this.email = email;
        this.pass = pass;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.creditLimit = creditLimit;
    }
}
