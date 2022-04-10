package com.ecommerce.services.impls;

import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.services.LoginServices;
import com.ecommerce.utils.mappers.UserMapper;

public class LoginServicesImpl implements LoginServices {

    private final static LoginServicesImpl INSTANCE = new LoginServicesImpl();


    private final UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();


    public static LoginServicesImpl getInstance() {
        return INSTANCE;
    }

    public UserBean findUserByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        System.out.println(user);
        if (user == null)
            return null;
        else {
            UserBean userBean = UserMapper.INSTANCE.userEntityToUserBean(user);
            System.out.println(userBean);
            return userBean;
        }
    }

    @Override
    public UserBean findUserById(int id) {
        return UserMapper.INSTANCE.userEntityToUserBean(userRepository.findById(id));
    }


}
