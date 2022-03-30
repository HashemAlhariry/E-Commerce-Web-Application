package com.ecommerce.presentation.beans;

public class ViewCartItem {
    private long id;
    private int quantity;

    public ViewCartItem(long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
    public ViewCartItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
