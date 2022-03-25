package com.ecommerce.presentation.beans;

public class CategoryBean {
    private int categoryId;
    private String categoryName;
    private String categoryImage;

    public CategoryBean(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
    public CategoryBean( String categoryName) {
        this.categoryName = categoryName;
    }
    public CategoryBean(){}

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {return categoryImage;}

    public void setCategoryImage(String categoryImage) {this.categoryImage = categoryImage;}
    @Override
    public String toString() {
        return "CategoryEntity{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
