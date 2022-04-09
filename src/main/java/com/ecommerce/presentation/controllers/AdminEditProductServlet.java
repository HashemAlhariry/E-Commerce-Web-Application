package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.mappers.ProductMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "admin-edit-product", urlPatterns = {"/admin-edit-product"})
//@ServletSecurity(httpMethodConstraints = {@HttpMethodConstraint(value = "Get" , rolesAllowed = "admin"),@HttpMethodConstraint(value = "Post" , rolesAllowed = "admin")})
public class AdminEditProductServlet extends HttpServlet {

    private ServletContext servletContext;
    ProductService productService;

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
        productService = ProductServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idNumber=Long.parseLong(req.getParameter("productId"));
        ProductEntity productEntity = productService.findById(idNumber);
        ProductBean productBean = ProductMapper.INSTANCE.productEntityToBean(productEntity);
        req.setAttribute("editProduct",productBean);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL +"admin/pages/forms/edit_product.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
