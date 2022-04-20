package com.ecommerce.presentation.controllers;

import com.ecommerce.exceptions.FoundBeforeException;
import com.ecommerce.presentation.beans.ResponseMessageBean;
import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.services.UserService;
import com.ecommerce.services.impls.UserServiceImpl;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import org.apache.commons.mail.EmailException;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SignUp", urlPatterns = "/registration")
public class SignUpServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        UserService userService = new UserServiceImpl((String) req.getAttribute("reqId"));
        List<String> messages = new ArrayList<>();
        String userName = req.getParameter("register_name");
        String date = req.getParameter("register_birthday");
        String email = req.getParameter("register_email");
        String pass = req.getParameter("register_password");
        String address = req.getParameter("register_address");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(date, dateTimeFormatter);

        try {
            SignUpBean userRegistrationBean = new SignUpBean(userName, dateOfBirth, email, pass, address);
            String domain = getBaseUrl(req);
            userService.registerUser(userRegistrationBean, domain);
            messages.add("Created Successfully");
            messages.add("Check mail to verify");
            ResponseMessageBean responseMessageBean = new ResponseMessageBean("success", messages);
            out.println(new Gson().toJson(responseMessageBean));
        } catch (FoundBeforeException | EmailException | ConstraintViolationException e) {
            e.printStackTrace();
            messages.add(e.getMessage());
            ResponseMessageBean responseMessageBean = new ResponseMessageBean("failed", messages);
            out.println(new Gson().toJson(responseMessageBean));
        }
        // leh hna y set attribute 3l session d 3ml register msh 3amel login //TODO
//            req.getSession().setAttribute("userDto", signUpBean);

        // SignUpBean signUpBean =
        // registerServicesImpl.registerUser(userRegistrationBean);
        // req.getSession().setAttribute("userDto", signUpBean);
    }

    private String getBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme() + "://";
        String serverName = request.getServerName();
        String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
        String contextPath = request.getContextPath();
        return scheme + serverName + serverPort + contextPath;
    }
}