package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.LoginBean;
import com.ecommerce.utils.CommonString;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "login", urlPatterns = {"/login"})

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "login.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginBean loginBean = new LoginBean ( String userEmail, String userPassword );

            String email = req.getParameter("signup-email");
            String password = req.getParameter("signup-password");
            System.out.println("email" + email + "password" + password);

            if (email == null) {
                //error page
                resp.sendRedirect("");
            } else {
                if (loginBean.getEmail().equals(email) && loginBean.getPassword().equals(password)) {
                    //profile page
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
                    HttpSession session = req.getSession();
                } else {
                //error page
                    resp.sendRedirect("login.jsp?invalid");
                }
            }


        }



}
