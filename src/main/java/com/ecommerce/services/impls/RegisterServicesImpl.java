package com.ecommerce.services.impls;


import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.services.RegisterServices;
import com.ecommerce.utils.mappers.UserMapper;


public class RegisterServicesImpl implements RegisterServices {


    private final static RegisterServicesImpl INSTANCE = new RegisterServicesImpl();
    private final UserRepository userRepository = UserRepositoryImpl.getInstance();


    public static RegisterServicesImpl getInstance() {
        return INSTANCE;
    }


    @Override
    public SignUpBean registerUser(SignUpBean signUpBean) {

        UserEntity user = UserMapper.INSTANCE.userRegBeanToEntity(signUpBean);
        UserEntity userSaved = userRepository.saveUser(user);
        SignUpBean userDTO1 = UserMapper.INSTANCE.userRegEntityToBean(userSaved);
        System.out.println("From Service " + userSaved);
        return userDTO1;
    }
}
