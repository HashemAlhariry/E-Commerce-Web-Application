package com.ecommerce.services.impls;

import com.ecommerce.handlers.Connector;
import com.ecommerce.presentation.beans.LoginUserBean;
import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.repositories.impl.CategoryRepositoryImpl;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.services.CategoryServices;
import com.ecommerce.services.LoginServices;
import com.ecommerce.utils.mappers.UserMapper;
import jakarta.persistence.EntityManager;

public class LoginServicesImpl implements LoginServices {

    private final static LoginServicesImpl INSTANCE = new LoginServicesImpl();


    private final UserRepository userRepository = UserRepositoryImpl.getInstance();


    public static LoginServicesImpl getInstance() {
        return INSTANCE;
    }

    public LoginUserBean findUserByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null)
            return null;
        else {
            LoginUserBean userDto = UserMapper.INSTANCE.userEntityToBean(user);
            return userDto;
        }
    }



}
