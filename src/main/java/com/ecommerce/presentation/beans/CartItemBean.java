package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemBean that = (CartItemBean) o;
        return productBean.equals(that.productBean);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productBean);
    }
}
