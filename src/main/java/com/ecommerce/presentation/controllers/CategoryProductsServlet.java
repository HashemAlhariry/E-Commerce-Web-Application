package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.CategoryBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.ProductServiceImpl;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "category-product", urlPatterns = {"/categorized-product"})

public class CategoryProductsServlet extends HttpServlet {
    ServletContext servletContext;

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl((String) req.getAttribute("reqId"));

        if (req.getParameterValues("categoryId") != null) {
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));

            List<ProductBean> categorizedProductsBeans = productService.getFilteredProductsBeans(1, 12, new ArrayList<>(List.of(req.getParameter("categoryId"))));
            req.setAttribute("categorizedProducts", categorizedProductsBeans);
            req.setAttribute("categoryId", categoryId);
            List<CategoryBean> categoryBeans = (List<CategoryBean>) servletContext.getAttribute("currentCategories");
            req.setAttribute("category", categoryBeans.stream().filter(c -> c.getCategoryId() == categoryId).findFirst().get());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "category-products.jsp");
            requestDispatcher.forward(req, resp);
        }
        //TODO if not entered id
        else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "404.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl((String) req.getAttribute("reqId"));

        PrintWriter out = resp.getWriter();

        if (req.getParameterValues("categoryId") != null) {
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
            int loadPage = Integer.parseInt(req.getParameter("loadPage"));
            List<ProductBean> categorizedProductsBeans = productService.getFilteredProductsBeans(loadPage, 12, new ArrayList<>(List.of(req.getParameter("categoryId"))));
            if (categorizedProductsBeans == null || categorizedProductsBeans.isEmpty()) {
                out.write("noMore");
            } else {
                req.setAttribute("categorizedProducts", categorizedProductsBeans);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "components/category-products-component.jsp");
                requestDispatcher.include(req, resp);
            }
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "404.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

}
