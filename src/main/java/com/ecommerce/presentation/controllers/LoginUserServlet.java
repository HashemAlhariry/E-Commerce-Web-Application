package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.LoginUserBean;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.services.LoginServices;
import com.ecommerce.services.impls.LoginServicesImpl;
import com.ecommerce.utils.CommonString;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "login", urlPatterns = {"/login"})

public class LoginUserServlet extends HttpServlet {

    private final LoginServices userServiceImpl = LoginServicesImpl.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "login.jsp");
        requestDispatcher.forward(req, resp);
        System.out.println("emailjfhushd");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String email = req.getParameter("signup-email");
        String password = req.getParameter("signup-password");
        System.out.println("email" + email + "password" + password);

        LoginUserBean userDto = userServiceImpl.findUserByEmail(email);
        if (userDto == null) {
            resp.sendRedirect("login.jsp?notFound");
        } else {
            if (userDto.getUserEmail().equals(email) && userDto.getUserPassword().equals(password))
            //user role
            {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("about.jsp");
                HttpSession session = req.getSession();

                // update name user
                session.setAttribute("userDto", userDto);

//            } else if (userDto.getUserEmail().equals(email) && userDto.getUserPassword().equals(password))
//            //admin role
//            {
////              RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/index.jsp");
//                req.getSession().setAttribute("userDto", userDto);
//                resp.sendRedirect("dashboard");
////              requestDispatcher.forward(request, response);
            } else {
                resp.sendRedirect("login.jsp");
            }
        }


    }
}
