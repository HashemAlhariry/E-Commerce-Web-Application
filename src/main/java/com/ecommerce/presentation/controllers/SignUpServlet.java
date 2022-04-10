package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.repositories.entites.Role;
import com.ecommerce.services.RegisterServices;
import com.ecommerce.services.impls.RegisterServicesImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "SignUp", urlPatterns = "/registration")
public class SignUpServlet extends HttpServlet {

    private final RegisterServices  registerServicesImpl = RegisterServicesImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("register-name");
        String date = req.getParameter("register-birthday");
        String email = req.getParameter("register-email");
        String pass = req.getParameter("register-password");
        String address = req.getParameter("register-address");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(date, dateTimeFormatter);

        SignUpBean userRegistrationBean = new SignUpBean( userName,  dateOfBirth,  email,  pass,  address);

        SignUpBean signUpBean = registerServicesImpl.registerUser(userRegistrationBean);
        resp.sendRedirect("login");
        // no need for setting the attribute on the session after registration //TODO
        req.getSession().setAttribute("userDto", signUpBean);

    }
}
