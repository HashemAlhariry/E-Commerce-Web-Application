package com.ecommerce.repositories.entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "newArrivals",query = "select p from ProductEntity p where p.state not in  (com.ecommerce.repositories.entites.ProductState.ARCHIVED,com.ecommerce.repositories.entites.ProductState.OUT_OF_STOCK)  ORDER BY p.creationDate DESC,p.id DESC "),
        @NamedQuery(name = "findAllByCategoryId",query = "select p from ProductEntity p   where  p.category.id = :category_id"),
        @NamedQuery(name = "findProductByName",query = "select p from ProductEntity p   where  p.name  LIKE  CONCAT('%',:product_name,'%')  and p.state<>com.ecommerce.repositories.entites.ProductState.ARCHIVED"),
        @NamedQuery(name = "findProductByPrice",query = "select p from ProductEntity p   where  p.price  = :product_price OR p.price  < :product_price"),
        @NamedQuery(name = "findProductByPriceAndCategoryId",query = "select p from ProductEntity p   where  (p.price  = :product_price OR p.price < :product_price) AND p.category.id = :category_id"),
        @NamedQuery(name = "relatedProducts",query = "select p from ProductEntity p where p.category.id = :category_id AND p.state not in  (com.ecommerce.repositories.entites.ProductState.ARCHIVED,com.ecommerce.repositories.entites.ProductState.OUT_OF_STOCK)  ORDER BY p.creationDate DESC,p.id DESC ")


})
@Getter @Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "MEDIUMINT NOT NULL AUTO_INCREMENT")
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price=BigDecimal.ZERO;

    @Column(nullable = false)
    private int quantity;

    private String description;
    private double rating;
    private double salePercentage;

    @Enumerated(EnumType.STRING)
    private ProductState state;
    private int totalPurchasesNumber;

    private String mainImage;
    @ElementCollection
    @CollectionTable(
            name = "product_images",
            joinColumns = @JoinColumn(name = "product_id")
    )
//    @Size(min = 1)
    private Set<String> images = new HashSet<>();

    private LocalDateTime creationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private CategoryEntity category;


    public  ProductEntity(){

    }
    public ProductEntity(String name, BigDecimal price, int quantity, String description , Set<String> images) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.images = images;
    }


    public ProductEntity(String name, BigDecimal price, int quantity, String description, double rating, double salePercentage, CategoryEntity category) {
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
        return "ProductEntity{" +
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
