package com.ecommerce.presentation.beans;

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

    public ProductBean getProductBean() {
        return productBean;
    }

    public void setProductBean(ProductBean productBean) {
        this.productBean = productBean;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(int requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CartItemBean{" +
                "productBean=" + productBean +
                ", requiredQuantity=" + requiredQuantity +
                ", state=" + state +
                '}';
    }
}
