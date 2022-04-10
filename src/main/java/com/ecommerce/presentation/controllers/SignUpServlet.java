package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.ResponseMessageBean;
import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.services.RegisterServices;
import com.ecommerce.services.UserService;
import com.ecommerce.services.impls.RegisterServicesImpl;
import com.ecommerce.services.impls.UserServiceImpl;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SignUp", urlPatterns = "/registration")
public class SignUpServlet extends HttpServlet {

    private final RegisterServices registerServicesImpl = RegisterServicesImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        List <String> messages = new ArrayList<>();
        String userName = req.getParameter("register_name");
        String date = req.getParameter("register_birthday");
        String email = req.getParameter("register_email");
        String pass = req.getParameter("register_password");
        String address = req.getParameter("register_address");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(date, dateTimeFormatter);
        if(userService.checkUserEmail(email))
        {
            messages.add("This email is already found");
            ResponseMessageBean responseMessageBean = new ResponseMessageBean("failed", messages);
            out.println(new Gson().toJson(responseMessageBean));
        }
        else
        {
            SignUpBean userRegistrationBean = new SignUpBean(userName, dateOfBirth, email, pass, address);
            SignUpBean signUpBean = registerServicesImpl.registerUser(userRegistrationBean);
            req.getSession().setAttribute("userDto", signUpBean);
            messages.add("Welcome");
            ResponseMessageBean responseMessageBean = new ResponseMessageBean("success", messages);
            out.println(new Gson().toJson(responseMessageBean));

        }


        //        if (userRegistrationBean == null) {
////            resp.sendRedirect("404.jsp");
//
//        } else {
//            SignUpBean signUpBean = registerServicesImpl.registerUser(userRegistrationBean);
//            req.getSession().setAttribute("userDto", signUpBean);
//
//        }

        // SignUpBean signUpBean =
        // registerServicesImpl.registerUser(userRegistrationBean);
        // req.getSession().setAttribute("userDto", signUpBean);

    }
}
