package com.ecommerce.repositories.entites;


import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "reversed ids",query = "select p from ProductEntity p ORDER BY p.id DESC "),
        @NamedQuery(name = "findAllByCategoryId",query = "select p from ProductEntity p   where  p.category.id = :category_id"),
        @NamedQuery(name = "findProductByName",query = "select p from ProductEntity p   where  p.name  LIKE  CONCAT('%',:product_name,'%') ")

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


    @ElementCollection
    @CollectionTable(
            name = "product_images",
            joinColumns = @JoinColumn(name = "product_id")
    )
    @Size(min = 1)
    private Set<String> images = new HashSet<>();

    @Temporal(TemporalType.DATE)
    private Date creationDate;

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

}
