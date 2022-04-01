package com.ecommerce.presentation.beans;


import java.math.BigDecimal;

public class ProductBean {

    private  long id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private String description;
    private double rating;
    private double salePercentage;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getSalePercentage() {
        return salePercentage;
    }

    public void setSalePercentage(double salePercentage) {
        this.salePercentage = salePercentage;
    }

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
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
                ", category=" + category +
                '}';
    }
}
