package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUserBean {

    private String email;
    private String pass;

    public LoginUserBean(String userEmail, String userPassword ) {
        this.email = userEmail;
        this.pass = userPassword;
    }

    public LoginUserBean() {

    }


    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "LoginUserBean{" +
                "email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
