package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUserBean {

    private String userEmail;
    private String userPassword;

    public LoginUserBean(String userEmail, String userPassword ) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public LoginUserBean() {

    }

    @Override
    public String toString() {
        return "LoginSignUpBean{" +
                ", email=" + userEmail + '\'' +
                ", password='" + userPassword + '\'' +
                '}';
    }
}
