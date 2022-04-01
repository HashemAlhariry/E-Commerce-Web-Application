package com.ecommerce.repositories.entites;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
@Table(name = "images")
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    public Image(){

    }
    public Image(String imagePath){
        this.imagePath = imagePath;
    }

}
