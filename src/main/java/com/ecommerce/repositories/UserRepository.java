package com.ecommerce.repositories;

import com.ecommerce.repositories.entites.Role;
import com.ecommerce.repositories.entites.UserEntity;
import jakarta.persistence.NoResultException;

import java.util.List;

public interface UserRepository {

    UserEntity findByEmail(String email) throws NoResultException;


}
