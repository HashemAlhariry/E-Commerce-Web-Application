package com.ecommerce.services;

import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.presentation.beans.UserViewBean;
import com.ecommerce.repositories.entites.UserEntity;

import java.util.List;

public interface UserService {
    List<UserViewBean>viewAll();
    List<UserViewBean> viewUserByEmail(String email);
    boolean checkUserEmail (String email);
    UserBean getUserByEmail(String email);
}
