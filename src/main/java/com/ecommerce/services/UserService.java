package com.ecommerce.services;

import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.presentation.beans.UserViewBean;

import java.util.List;

public interface UserService {
    List<UserViewBean>viewAll();
    List<UserViewBean> viewUserByEmail(String email);
    UserBean getUserByEmail(String email);
}
