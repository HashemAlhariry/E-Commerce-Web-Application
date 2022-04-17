package com.ecommerce.presentation.controllers;
import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.services.RegisterServices;
import com.ecommerce.services.impls.RegisterServicesImpl;
import jakarta.servlet.ServletException;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterServices registerServicesImpl = new RegisterServicesImpl((String) req.getAttribute("reqId"));
        String userName = req.getParameter("register-name");
        String date = req.getParameter("register-birthday");
        String email = req.getParameter("register-email");
        String pass = req.getParameter("register-password");
        String address = req.getParameter("register-address");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(date, dateTimeFormatter);
        SignUpBean userRegistrationBean = new SignUpBean(userName, dateOfBirth, email, pass, address);
        if (userRegistrationBean == null) {
            resp.sendRedirect("404.jsp");
        } else {
            SignUpBean signUpBean = registerServicesImpl.registerUser(userRegistrationBean);
            // leh hna y set attribute 3l session d 3ml register msh 3amel login //TODO
            req.getSession().setAttribute("userDto", signUpBean);
        }

        // SignUpBean signUpBean =
        // registerServicesImpl.registerUser(userRegistrationBean);
        // req.getSession().setAttribute("userDto", signUpBean);
    }
}