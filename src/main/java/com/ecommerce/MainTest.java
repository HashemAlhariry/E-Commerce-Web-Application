package com.ecommerce;

import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.OrderDetailRepository;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.Role;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.repositories.impl.CategoryRepositoryImpl;
import com.ecommerce.repositories.impl.OrderDetailRepositoryImpl;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;
import com.ecommerce.services.OrderDetailsService;
import com.ecommerce.services.impls.OrderDetailsServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class MainTest {
    public static void main(String[] args) {

        ProductRepository productRepository = ProductRepositoryImpl.getInstance();
        CategoryRepository categoryRepository = CategoryRepositoryImpl.getInstance();
        OrderDetailRepository orderDetailRepository = OrderDetailRepositoryImpl.getInstance();
        OrderDetailsService orderDetailsService = OrderDetailsServiceImpl.getInstance();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("amazonya");
        EntityManager em = emf.createEntityManager();

//        System.out.println(orderDetailsService.findAllById(1).get(0).);
////        Image image1 = new Image("imagepath1");
//        UserEntity userEntity = new UserEntity("osos","hashem@osos","marwa","shoubra el kheima", LocalDate.now(), Role.CUSTOMER, BigDecimal.valueOf(2000L));
//        System.out.println(categoryRepository.findById(1));
       // System.out.println("get entity by id "+productRepository.findById(1l).toString());
        //ProductEntity productEntity = productRepository.findById(1l);
//        ProductEntity productEntity = new ProductEntity();
//        productEntity.setName("s");
//        productEntity.setCategory(categoryRepository.findById(1));
//em.persist(productEntity);
//        System.out.println(productRepository.delete(productEntity));
//        ProductEntity product = new ProductEntity("Dell", new BigDecimal(20000) , 3, "ana laptop osama", Set.of("image1"));
//        image1.setProduct(product);
//        em.getTransaction().begin();
//        em.persist(userEntity);
//        em.persist(product);
//        em.getTransaction().commit();
//        em.clear();
//        em.close();

   //     System.out.println(ProductMapper.INSTANCE.listEntitiesToBeans(productRepository.findAll()));
//        TestEntity test = new TestEntity();
//        test.setId(1);
//        test.setName("asd");
//
//
//
//        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("amazonya");
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction et = entityManager.getTransaction();
//        et.begin();
//        entityManager.persist(test);
//        et.commit();
//        entityManager.close();
//
//        entityManagerFactory.close();
//        SessionFactory sessionFactory=new Configuration().buildSessionFactory();
//        Session session=sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(test);
//        session.getTransaction().commit();
//        session.close();





//        ProductEntity productEntity=ProductRepositoryImpl.getInstance().save(new ProductEntity("p1",20,3));
//        productEntity.setPrice(50);
//        ProductRepositoryImpl.getInstance().update(productEntity);
//        System.out.println(productEntity.getId()+"  ; ; ; ;");
//        ProductEntity productEntity=new ProductServiceImpl().findById(1L);
//
//        ProductBean productBean=ProductMapper.INSTANCE.productEntityToBean(productEntity);
//        System.out.println(productBean);

//        CategoryEntity categoryEntity1 = new CategoryEntity();
//        categoryEntity1.setCategoryName("Computer & Laptop");
//        categoryEntity1.setCategoryImage("assets/images/demos/demo-4/cats/1.png");
//
//        CategoryEntity categoryEntity2 = new CategoryEntity();
//        categoryEntity2.setCategoryName("Smart Watches");
//        categoryEntity2.setCategoryImage("assets/images/demos/demo-4/cats/6.png");
//
//        CategoryEntity categoryEntity3 = new CategoryEntity();
//        categoryEntity3.setCategoryName("Smart Phones");
//        categoryEntity3.setCategoryImage("assets/images/demos/demo-4/cats/3.png");
//        CategoryRepositoryImpl.getInstance().save(categoryEntity3);
//
//        ProductEntity productEntityC = new ProductEntity();
//        productEntityC.setPrice(123);
//        productEntityC.setName("Osa");
//        productEntityC.setCategory(categoryEntity1);
//
//        ProductEntity productEntity2 = new ProductEntity();
//        productEntity2.setPrice(123);
//        productEntity2.setName("Oso");
//        productEntity2.setCategory(categoryEntity2);
//        ProductRepositoryImpl.getInstance().save(productEntity2);
//        ProductRepositoryImpl.getInstance().save(productEntityC);

    }
}
