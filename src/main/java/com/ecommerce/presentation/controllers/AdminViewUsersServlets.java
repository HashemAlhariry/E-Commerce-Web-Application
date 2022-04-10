package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.UserViewBean;
import com.ecommerce.services.UserService;
import com.ecommerce.services.impls.UserServiceImpl;
import com.ecommerce.utils.CommonString;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "adminViewUsers", urlPatterns = {"/admin-view-users"})

public class AdminViewUsersServlets extends HttpServlet {

    private ServletContext servletContext;
    private UserService userService;

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
        userService = UserServiceImpl.getInstance();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserViewBean> allUsers = userService.viewAll();
        System.out.println(allUsers.toString());
        req.setAttribute("allUsers", allUsers);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "admin/pages/tables/users_view.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        if (email != null) email = email.trim();
        List<UserViewBean> allUsers = userService.viewUserByEmail(email);
        req.setAttribute("allUsers", allUsers);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "admin/pages/tables/users_view.jsp");
        requestDispatcher.forward(req, resp);
    }
}
