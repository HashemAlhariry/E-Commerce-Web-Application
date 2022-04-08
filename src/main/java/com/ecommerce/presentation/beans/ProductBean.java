package com.ecommerce.presentation.beans;

import com.ecommerce.repositories.entites.ProductState;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class ProductBean {

    private long id;
    private String name;
    private BigDecimal price=BigDecimal.ZERO;
    private int quantity;
    private String description;
    private double rating;
    private double salePercentage;
    private ProductState state;
    private int totalPurchasesNumber;
    private String mainImage;
    private Set<String> images = new HashSet<>();
    private LocalDate creationDate;
    private CategoryBean category;

    public  ProductBean(){}
    public ProductBean(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductBean(int id, String name, BigDecimal price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductBean(String name, BigDecimal price, int quantity, String description, double rating, double salePercentage, CategoryBean category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.rating = rating;
        this.salePercentage = salePercentage;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", salePercentage=" + salePercentage +
                ", state=" + state +
                ", totalPurchasesNumber=" + totalPurchasesNumber +
                ", images=" + images +
                ", creationDate=" + creationDate +
                ", category=" + category +
                '}';
    }
}
