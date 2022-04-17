package com.ecommerce.tld.util;

import com.ecommerce.presentation.beans.ProductBean;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductListSorting {
    public static List<ProductBean> sortByPriceAsc(List<ProductBean> productBeanList) {
        Collections.sort(productBeanList, Comparator.comparingInt(a -> a.getPrice().intValue()));
        return productBeanList;
    }
    public static List<ProductBean> sortByPriceDesc(List<ProductBean> productBeanList) {
        Collections.sort(productBeanList, (a,b)->{return b.getPrice().intValue()-a.getPrice().intValue();});
        return productBeanList;
    }
    public static List<ProductBean> sortByDate(List<ProductBean> productBeanList) {
        Collections.sort(productBeanList, (a,b)-> b.getCreationDate().compareTo((a.getCreationDate())));
        return productBeanList;
    }
}
