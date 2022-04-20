package com.ecommerce.services.impls;


import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.services.RegisterServices;
import com.ecommerce.utils.mappers.UserMapper;


public class RegisterServicesImpl implements RegisterServices {


    private final UserRepository userRepository;

    public RegisterServicesImpl(String reqId) {
        userRepository = new UserRepositoryImpl(reqId);
    }


    @Override
    public SignUpBean registerUser(SignUpBean signUpBean) {
        UserEntity user1 = UserMapper.INSTANCE.userRegBeanToEntity(signUpBean);
        String email = user1.getEmail();
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            UserEntity userSaved = userRepository.saveUser(user1);
            SignUpBean userDTO1 = UserMapper.INSTANCE.userRegEntityToBean(userSaved);
            return userDTO1;
        } else {
            return null;
        }

//
//        UserEntity user = UserMapper.INSTANCE.userRegBeanToEntity(signUpBean);
//        UserEntity userSaved = userRepository.saveUser(user);
//        SignUpBean userDTO1 = UserMapper.INSTANCE.userRegEntityToBean(userSaved);
//        return userDTO1;
    }


}
