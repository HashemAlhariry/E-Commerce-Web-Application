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

public class MainTest {
    public static void main(String[] args) {

        ProductRepository productRepository = ProductRepositoryImpl.getInstance();
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

////        Image image1 = new Image("imagepath1");
//        UserEntity userEntity = new UserEntity("osos","hashem@osos","marwa","shoubra el kheima", LocalDate.now(), Role.CUSTOMER, BigDecimal.valueOf(2000L));


//        ProductEntity product = new ProductEntity("Dell", new BigDecimal(20000) , 3, "ana laptop osama", Set.of("image1"));
////        image1.setProduct(product);
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





  //      OrderDetailsRepositoryImpl orderDetailsRepository =  OrderDetailsRepositoryImpl.getInstance();


    }
}
