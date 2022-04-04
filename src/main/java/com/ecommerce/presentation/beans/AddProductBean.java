package com.ecommerce.presentation.beans;

import com.ecommerce.utils.ValidationUtil;
import jakarta.servlet.http.Part;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collection;

@Getter
@Setter
public class AddProductBean {
    @NotNull(message = "Product name size must be 2 at least")
    @Size(min = 2,max = 50,message = "Product name size must be between 2 and 50 at least")
    String name;
    @Size(max = 200,message = "Product description max size is 200")
    String description;
    @NotNull(message = "Product price can't be null")
    BigDecimal price;
    int quantity;
    int categoryId;
    @Size(min = 1,message = "Product images size must be 1 at least")
    Collection<Part> images;

    public AddProductBean(String name, String description, BigDecimal price, int quantity, int categoryId, Collection<Part> images) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.images = images;
        ValidationUtil.getInstance().validate(this);
    }
}
