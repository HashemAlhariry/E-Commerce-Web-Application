package com.ecommerce.presentation.beans;

public class LoginBean {

    private String userEmail;
    private String userPassword;

    public LoginBean ( String userEmail, String userPassword ) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "LoginSignUpBean{" +
                ", email=" + userEmail + '\'' +
                ", password='" + userPassword + '\'' +
                '}';
    }
}
