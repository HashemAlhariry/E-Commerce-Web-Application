package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartItemBean {
    private ProductBean productBean;
    private int requiredQuantity;
    private int state;

    public CartItemBean(ProductBean productBean, int requiredQuantity) {
        this.productBean = productBean;
        this.requiredQuantity = requiredQuantity;
    }

    public CartItemBean(ProductBean productBean, int requiredQuantity, int state) {
        this.productBean = productBean;
        this.requiredQuantity = requiredQuantity;
        this.state = state;
    }
    public CartItemBean(){}



    @Override
    public String toString() {
        return "CartItemBean{" +
                "productBean=" + productBean +
                ", requiredQuantity=" + requiredQuantity +
                ", state=" + state +
                '}';
    }
}
