package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.LoginUserBean;
import com.ecommerce.utils.CommonString;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "ComingSoon", urlPatterns = {"/comingsoon"})

public class ComingSoonPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "coming-soon.jsp");
        requestDispatcher.forward(req, resp);

    }
}