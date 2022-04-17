package com.ecommerce.services.impls;

import com.ecommerce.presentation.beans.UserViewBean;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.services.UserService;
import com.ecommerce.utils.mappers.UserMapper;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(String reqId) {
        userRepository = new UserRepositoryImpl(reqId);
    }

    @Override
    public List<UserViewBean> viewAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return UserMapper.INSTANCE.userEntitiesToViewUserBeans(userEntities);
    }

    @Override
    public List<UserViewBean> viewUserByEmail(String email) {
        List<UserEntity> userEntities = userRepository.getUserByEmail(email);
        return UserMapper.INSTANCE.userEntitiesToViewUserBeans(userEntities);
    }

    @Override
    public boolean checkUserEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return userEntity != null ;
    }
}
