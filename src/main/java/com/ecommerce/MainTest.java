package com.ecommerce;

import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.Role;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.repositories.impl.CategoryRepositoryImpl;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.ProductServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.repositories.impl.CategoryRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
        public static void main(String[] args) {

        ProductRepository productRepository = ProductRepositoryImpl.getInstance();
        List<String> categoriesIds = new ArrayList<>();
        categoriesIds.add("1");
        categoriesIds.add("3");
        System.out.println(productRepository.getFilteredProducts(1,5,categoriesIds));
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

                // System.out.println(ProductMapper.INSTANCE.listEntitiesToBeans(productRepository.findAll()));
                // TestEntity test = new TestEntity();
                // test.setId(1);
                // test.setName("asd");
                //
                //
                //
                // EntityManagerFactory
                // entityManagerFactory=Persistence.createEntityManagerFactory("amazonya");
                //
                // EntityManager entityManager = entityManagerFactory.createEntityManager();
                // EntityTransaction et = entityManager.getTransaction();
                // et.begin();
                // entityManager.persist(test);
                // et.commit();
                // entityManager.close();
                //
                // entityManagerFactory.close();
                // SessionFactory sessionFactory=new Configuration().buildSessionFactory();
                // Session session=sessionFactory.openSession();
                // session.beginTransaction();
                // session.save(test);
                // session.getTransaction().commit();
                // session.close();

                // OrderDetailsRepositoryImpl orderDetailsRepository =
                // OrderDetailsRepositoryImpl.getInstance();

//                CategoryEntity categoryEntity1 = new CategoryEntity();
//                categoryEntity1.setCategoryName("Computer & Laptop");
//                categoryEntity1.setCategoryImage("assets/images/demos/demo-4/cats/1.png");
//
//                CategoryEntity categoryEntity2 = new CategoryEntity();
//                categoryEntity2.setCategoryName("Smart Watches");
//                categoryEntity2.setCategoryImage("assets/images/demos/demo-4/cats/6.png");
//
//                CategoryEntity categoryEntity3 = new CategoryEntity();
//                categoryEntity3.setCategoryName("Smart Phones");
//                categoryEntity3.setCategoryImage("assets/images/demos/demo-4/cats/3.png");
//                CategoryRepositoryImpl.getInstance().save(categoryEntity1);
//                CategoryRepositoryImpl.getInstance().save(categoryEntity2);
//                CategoryRepositoryImpl.getInstance().save(categoryEntity3);
                //
                // ProductEntity productEntityC = new ProductEntity();
                // productEntityC.setPrice(123);
                // productEntityC.setName("Osa");
                // productEntityC.setCategory(categoryEntity1);
                //
                // ProductEntity productEntity2 = new ProductEntity();
                // productEntity2.setPrice(123);
                // productEntity2.setName("Oso");
                // productEntity2.setCategory(categoryEntity2);
                // ProductRepositoryImpl.getInstance().save(productEntity2);
                // ProductRepositoryImpl.getInstance().save(productEntityC);

        }
}
