package com.ecommerce.presentation.controllers;

import com.ecommerce.exceptions.IllegalInputException;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "filter", urlPatterns = {"/filter"})
public class FiltrationServlet extends HttpServlet {
    ServletContext servletContext;

    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ProductService productService=new ProductServiceImpl((String) request.getAttribute("reqId"));

        String laptopsCheck = request.getParameter("laptops");
        String mobilesCheck = request.getParameter("mobiles");
        String watchesCheck = request.getParameter("watches");
        if(laptopsCheck == null||mobilesCheck== null||watchesCheck== null){ throw new IllegalInputException();}
        String pageNumberAsString = request.getParameter("pageNumber");
        List<ProductBean> filteredProductsBeans;
        List<String> categoriesIds = new ArrayList<>();

        if(laptopsCheck.equalsIgnoreCase("true")) {
            categoriesIds.add("1");
        }
        if(mobilesCheck.equalsIgnoreCase("true")) {
            categoriesIds.add("3");
        }
        if(watchesCheck.equalsIgnoreCase("true")) {
            categoriesIds.add("2");
        }
        String[] categoriesIdArr = new String[categoriesIds.size()];
        long totalCount = productService.getProductsCountInCategories(categoriesIds.toArray(categoriesIdArr));
        int countOfProductsPerPage = 12;
        int numberOfPages = (int)Math.ceil((float)totalCount/countOfProductsPerPage);


        if (pageNumberAsString == null){
            filteredProductsBeans = productService.getFilteredProductsBeans(1,countOfProductsPerPage,categoriesIds);
            request.setAttribute("currentPageNumber", 1);

        }else{
            int pageNumber = Integer.parseInt(pageNumberAsString);
            filteredProductsBeans = productService.getFilteredProductsBeans(pageNumber,countOfProductsPerPage,categoriesIds);
            request.setAttribute("currentPageNumber", pageNumber);
        }

        if(filteredProductsBeans != null){
            request.setAttribute("allProducts",filteredProductsBeans);
            request.setAttribute("totalCount",totalCount);
            request.setAttribute("numberOfPages", numberOfPages);
            request.setAttribute("currentPageProductsNumber", filteredProductsBeans.size());
            request.setAttribute("filtration", true);
            request.setAttribute("laptopsCount", productService.getProductsCountInCategories("1"));
            request.setAttribute("watchesCount", productService.getProductsCountInCategories("2"));
            request.setAttribute("mobilesCount", productService.getProductsCountInCategories("3"));



            RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "shop.jsp");
            requestDispatcher.forward(request, response);
        }
        else{
            throw new IllegalInputException();
        }

    }


}
