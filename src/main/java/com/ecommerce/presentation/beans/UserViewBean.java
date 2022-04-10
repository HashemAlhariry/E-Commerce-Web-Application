package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class UserViewBean {

    private int id;
    private String userName;
    private String email;
    private String address;
    private LocalDate dateOfBirth;
    private String role;
    private BigDecimal creditLimit;
}
