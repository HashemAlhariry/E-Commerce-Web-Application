package com.ecommerce;

import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;

import java.util.List;

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





//        ProductEntity productEntity=ProductRepositoryImpl.getInstance().save(new ProductEntity("p1",20,3));
//        productEntity.setPrice(50);
//        ProductRepositoryImpl.getInstance().update(productEntity);
//        System.out.println(productEntity.getId()+"  ; ; ; ;");
//        ProductEntity productEntity=new ProductServiceImpl().findById(1L);
//
//        ProductBean productBean=ProductMapper.INSTANCE.productEntityToBean(productEntity);
//        System.out.println(productBean);

        List<ProductEntity>productEntities = ProductRepositoryImpl.getInstance().getLast10();
        for(ProductEntity productEntity:productEntities){
            System.out.println(productEntity.getId());
        }
        System.out.println(productEntities.size());
    }
}
