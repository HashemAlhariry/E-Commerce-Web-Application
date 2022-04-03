package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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

    @Override
    public String toString() {
        return "CategoryBean{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryImage='" + categoryImage + '\'' +
                '}';
    }
}
