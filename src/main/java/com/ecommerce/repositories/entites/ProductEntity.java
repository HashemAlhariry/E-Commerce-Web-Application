package com.ecommerce.repositories.entites;


import javax.persistence.*;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "reversed ids",query = "select p from ProductEntity p ORDER BY p.id DESC ")
       // LIMIT 5  ORDER BY c.name DESC
})
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(columnDefinition = "MEDIUMINT NOT NULL AUTO_INCREMENT")
    private  long id;
    private String name;
    private  int price;
    private int quantity;

    public  ProductEntity(){

    }
    public ProductEntity(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductEntity(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
