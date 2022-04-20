package com.ecommerce.services;

import com.ecommerce.exceptions.FoundBeforeException;
import com.ecommerce.exceptions.NotFoundException;
import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.presentation.beans.UserViewBean;
import org.apache.commons.mail.EmailException;
import com.ecommerce.presentation.beans.UserBean;

import java.net.MalformedURLException;
import java.util.List;

public interface UserService {
    List<UserViewBean>viewAll();
    List<UserViewBean> viewUserByEmail(String email);
    boolean registerUser (SignUpBean signUpBean,String domain) throws FoundBeforeException, MalformedURLException, EmailException;
    boolean confirmRegister(String code) throws NotFoundException;
    boolean checkUserEmail (String email);
    UserBean getUserByEmail(String email);
}
