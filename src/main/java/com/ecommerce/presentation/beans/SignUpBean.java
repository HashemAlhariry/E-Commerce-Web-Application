package com.ecommerce.presentation.beans;

public class SignUpBean {

    private String userName;
    private String userBirthDay;
    private String userEmail;
    private String userPassword;
    private String userJob;
    private String userAddress;
    private String userCreditLimit;


    public SignUpBean(String userName, String userBirthDay, String userEmail, String userPassword, String userJob, String userAddress, String userCreditLimit ) {
        this.userName = userName;
        this.userBirthDay = userBirthDay;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userJob = userJob;
        this.userAddress = userAddress;
        this.userCreditLimit = userCreditLimit;
    }




    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBirthDay() {
        return userBirthDay;
    }

    public void setUserBirthDay(String userBirthDay) {
        this.userBirthDay = userBirthDay;
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

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserCreditLimit() {
        return userCreditLimit;
    }

    public void setUserCreditLimit(String userCreditLimit) {
        this.userCreditLimit = userCreditLimit;
    }


    @Override
    public String toString() {
        return "LoginSignUpBean{" +
                ", name='" + userName + '\'' +
                ", birthday=" + userBirthDay + '\'' +
                ", email=" + userEmail + '\'' +
                ", password='" + userPassword + '\'' +
                ", job=" + userJob + '\'' +
                ", address=" + userAddress + '\'' +
                ",  creditLimit=" +  userCreditLimit +
                '}';
    }
}
