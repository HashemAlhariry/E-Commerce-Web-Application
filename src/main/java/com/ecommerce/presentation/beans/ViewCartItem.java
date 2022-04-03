package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ViewCartItem {
    private long id;
    private int quantity;

    public ViewCartItem(long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
    public ViewCartItem() {
    }
}
