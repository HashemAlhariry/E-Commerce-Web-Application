package com.ecommerce;

import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.impl.CategoryRepositoryImpl;
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

        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setCategoryName("Computer & Laptop");
        categoryEntity1.setCategoryImage("assets/images/demos/demo-4/cats/1.png");

        CategoryEntity categoryEntity2 = new CategoryEntity();
        categoryEntity2.setCategoryName("Smart Watches");
        categoryEntity2.setCategoryImage("assets/images/demos/demo-4/cats/6.png");

        CategoryEntity categoryEntity3 = new CategoryEntity();
        categoryEntity3.setCategoryName("Smart Phones");
        categoryEntity3.setCategoryImage("assets/images/demos/demo-4/cats/3.png");
        CategoryRepositoryImpl.getInstance().save(categoryEntity3);

        ProductEntity productEntityC = new ProductEntity();
        productEntityC.setPrice(123);
        productEntityC.setName("Osa");
        productEntityC.setCategory(categoryEntity1);

        ProductEntity productEntity2 = new ProductEntity();
        productEntity2.setPrice(123);
        productEntity2.setName("Oso");
        productEntity2.setCategory(categoryEntity2);
        ProductRepositoryImpl.getInstance().save(productEntity2);
        ProductRepositoryImpl.getInstance().save(productEntityC);

        List<ProductEntity>productEntities = ProductRepositoryImpl.getInstance().findAllByCategoryId(3);
        for(ProductEntity productEntity:productEntities){
            System.out.println(productEntity.getId());
        }
        System.out.println(productEntities.size());
    }
}
