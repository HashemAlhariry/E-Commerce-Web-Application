package com.ecommerce;

import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;

public class MainTest {
    public static void main(String[] args) {
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





        ProductRepositoryImpl.getInstance().save(new ProductEntity("p1",20,3));
    }
}
