package com.ecommerce.presentation.controllers;

import com.ecommerce.exceptions.CustomValidationException;
import com.ecommerce.presentation.beans.AddProductBean;
import com.ecommerce.presentation.beans.ResponseMessageBean;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.FileUtil;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.validation.ValidationException;
import org.hibernate.exception.ConstraintViolationException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "admin-add-product", urlPatterns = {"/admin-add-product"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class AdminAddProductServlet extends HttpServlet {

    private ServletContext servletContext;
    private ProductService productService = ProductServiceImpl.getInstance();

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "admin/pages/forms/add_new_product.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        List<String> messages = new ArrayList<>();
        try {
            String name = req.getParameter("name");
            BigDecimal price = new BigDecimal(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            String description = req.getParameter("description");
            int categoryId = Integer.parseInt(req.getParameter("category"));
            Collection<Part> parts = getParts(req);
            AddProductBean addProductBean = new AddProductBean(name, description, price, quantity, categoryId, parts);
            productService.save(addProductBean);
            messages.add("Added Successfully");
            ResponseMessageBean responseMessageBean = new ResponseMessageBean("success", messages);
            out.println(new Gson().toJson(responseMessageBean));
        } catch (FileNotFoundException fne) {
            messages.add("Error While Uploading Your File");
            ResponseMessageBean responseMessageBean = new ResponseMessageBean("failed", messages);
            out.println(new Gson().toJson(responseMessageBean));
        } catch (NumberFormatException | ConstraintViolationException | CustomValidationException ve) {
            messages.add(ve.getMessage());
            ResponseMessageBean responseMessageBean = new ResponseMessageBean("failed", messages);
            out.println(new Gson().toJson(responseMessageBean));
        }
    }

    private Collection<Part> getParts(HttpServletRequest req) throws ServletException, IOException, CustomValidationException {
        Collection<Part> parts = new ArrayList<>();
        Part mainPart = req.getPart("img1");
        if (mainPart == null || FileUtil.getINSTANCE().getFileName(mainPart).isEmpty() || FileUtil.getINSTANCE().getFileName(mainPart).get().isEmpty()) {
            throw new CustomValidationException("Main image not exist");
        }
        parts.add(mainPart);
        addIfExist(req, parts, "img2");
        addIfExist(req, parts, "img3");
        addIfExist(req, parts, "img4");
        return parts;
    }

    private void addIfExist(HttpServletRequest req, Collection<Part> parts, String name) throws ServletException, IOException, ValidationException {
        Part part = req.getPart(name);
        if (part != null) {
            parts.add(req.getPart(name));
        }
    }
}
