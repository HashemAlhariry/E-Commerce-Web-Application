package com.ecommerce;

import com.ecommerce.handlers.Connector;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.CartRepository;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.*;
import com.ecommerce.repositories.impl.CartRepositoryImpl;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.ecommerce.tld.util.ProductListSorting;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.ecommerce.repositories.impl.CategoryRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class MainTest {
    public static void main(String[] args) {

//        CartRepository cartRepository = CartRepositoryImpl.getInstance();
//        cartRepository.deleteUserCart(2);

            UserEntity user = UserRepositoryImpl.getInstance().findById(2);




//        ProductRepository productRepository = ProductRepositoryImpl.getInstance();
//        List<String> categoriesIds = new ArrayList<>();
//        categoriesIds.add("1");
//        categoriesIds.add("3");
//        //System.out.println(productRepository.getFilteredProducts(1,5,categoriesIds));
//        ProductService productService = ProductServiceImpl.getInstance();
//        List<ProductBean> list = productService.getProductsOfPage(1);
//                List<ProductBean> sortedList =  ProductListSorting.sortByPriceAsc(list);
//                //sortedList.forEach(p-> System.out.println(p.getPrice()));
//                System.out.println("=====================================================================");
//                sortedList = ProductListSorting.sortByDate(list);
//                sortedList.forEach(p-> System.out.println(p.getCreationDate()));
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("amazonya");
//        EntityManager em = emf.createEntityManager();
//        System.out.println(productRepository.getSinglePageProducts(2,20));
//        System.out.println(ProductServiceImpl.getInstance().getAllProductsCount());
//        System.out.println(ProductServiceImpl.getInstance().getProductsOfPage(1));
//        int x = 12;
//        System.out.println(Math.ceil( (float)x /5f ));
//        System.out.println("the count of the categories is "+CategoryRepositoryImpl.getInstance().getCount());
//        productRepository.getSinglePageContent(2,8).forEach(System.out::println);
 //       CategoryRepositoryImpl.getInstance().getSinglePageContent(1,3).forEach(System.out::println);

                // ProductRepository productRepository = ProductRepositoryImpl.getInstance();
                // EntityManagerFactory emf =
                // Persistence.createEntityManagerFactory("amazonya");
                // EntityManager em = emf.createEntityManager();
                //// Image image1 = new Image("imagepath1");
                // UserEntity userEntity = new UserEntity("osos","hashem@osos","marwa","shoubra
                // el kheima", LocalDate.now(), Role.CUSTOMER, BigDecimal.valueOf(2000L));
                //
                //

                // ProductEntity product = new ProductEntity("Dell", new BigDecimal(20000) , 3,
                // "ana laptop osama", Set.of("image1"));
                //// image1.setProduct(product);
                // em.getTransaction().begin();
                // em.persist(userEntity);
                // em.persist(product);
                // em.getTransaction().commit();
                // em.clear();
                // em.close();


//        ProductEntity productEntity=ProductRepositoryImpl.getInstance().save(new ProductEntity("p1",20,3));
//        productEntity.setPrice(50);
//        ProductRepositoryImpl.getInstance().update(productEntity);
//        System.out.println(productEntity.getId()+"  ; ; ; ;");
//        ProductEntity productEntity=new ProductServiceImpl().findById(1L);
//
//        ProductBean productBean=ProductMapper.INSTANCE.productEntityToBean(productEntity);
//        System.out.println(productBean);


    }
}
