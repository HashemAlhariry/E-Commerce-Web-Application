package com.ecommerce.repositories;

import com.ecommerce.repositories.entites.UserEntity;

import java.util.List;

public interface UserRepository extends  Repository<UserEntity,Long> {

    List<UserEntity> getUserByEmail(String email);


}
