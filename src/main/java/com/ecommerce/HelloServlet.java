package com.ecommerce;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
 

    public void init() {
  
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
   
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

}