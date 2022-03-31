package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.SignUpBean;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "SignUp", urlPatterns = "/registration")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("from Reegistration");


        String firstName = req.getParameter("register-name");
        String birthDate = req.getParameter("register-birthday");
        String email = req.getParameter("register-email");
        String password = req.getParameter("register-password");
        String job = req.getParameter("register-job");
        String address = req.getParameter("register-address");
        String creditLimit = req.getParameter("register-credit limit");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(birthDate, dateTimeFormatter);

        SignUpBean signUpBean = new SignUpBean

        signUpBean.setUserName(firstName);
        signUpBean.setUserBirthDay(String.valueOf(dateOfBirth));
        signUpBean.setUserEmail(email);
        signUpBean.setUserPassword(password);
        signUpBean.setUserJob(job);
        signUpBean.setUserAddress(address);
        signUpBean.setUserCreditLimit(creditLimit);

    }
}
