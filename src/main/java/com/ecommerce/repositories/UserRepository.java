package com.ecommerce.repositories;

import com.ecommerce.repositories.entites.UserEntity;
import jakarta.persistence.NoResultException;

import java.util.List;

public interface UserRepository extends Repository<UserEntity,Integer>{

    
    List<UserEntity> getUserByEmail(String email);
    UserEntity findByEmail(String email) throws NoResultException;
    UserEntity saveUser(UserEntity user);
    UserEntity updateUser(UserEntity user);



}
