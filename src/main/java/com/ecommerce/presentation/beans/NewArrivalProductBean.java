package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class NewArrivalProductBean {
    private long id;
    private String name;
    private BigDecimal price = BigDecimal.ZERO;
    private int quantity;
    private String description;
    private double rating;
    private double salePercentage;
    private String state;
    private int totalPurchasesNumber;
    private String mainImage;
    private CategoryBean category;

}
