package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.ResponseMessageBean;
import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.presentation.beans.ViewCartItem;
import com.ecommerce.services.CartService;
import com.ecommerce.services.LoginServices;
import com.ecommerce.services.impls.CartServiceImpl;
import com.ecommerce.services.impls.LoginServicesImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "login", urlPatterns = {"/login"})

public class LoginUserServlet extends HttpServlet {

    private final LoginServices userServiceImpl = LoginServicesImpl.getInstance();
    private final CartService cartService = CartServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "login.jsp");
        requestDispatcher.forward(req, resp);
        System.out.println("emailjfhushd");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("signup-email");
        String password = request.getParameter("signup-password");
        String rememberMe = request.getParameter("rememberMe");
        String cart = request.getParameter("cart");

        System.out.println(cart);
        UserBean userBean = userServiceImpl.findUserByEmail(email);
        if (userBean == null) {
                // return user to login page with error message
            List<String> messages = new ArrayList<>();
            messages.add("There's something wrong in your Email or Password, Please try again");
            ResponseMessageBean responseMessageBean = new ResponseMessageBean("failed", messages);
        }
        else {


            if (userBean.getEmail().equals(email) && userBean.getPass().equals(password)) {


                // add id/password to cookie to user
                addCookiesToResponse(request,response,userBean,rememberMe);

                if( userBean.getRole().equals("CUSTOMER")){

                    //get user cart from json local database
                    List<CartItemBean> cartItemBeanListFromJSPJson = Util.parseCartJsonToCart(cart,cartService);

                    //get user cart from Database
                    List<CartItemBean> cartItemBeanListFromDataBase = cartService.getUserCartFromDataBase(userBean.getId());
                    List<CartItemBean> cartItemBeans = mergeUserCarts(cartItemBeanListFromJSPJson,cartItemBeanListFromDataBase);
                    List<ViewCartItem> viewCartItems = fromCartItemBeansToViewCartItems(cartItemBeans);
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(viewCartItems);

                    request.setAttribute("cartItemBeans",viewCartItems);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "index.jsp");
                    requestDispatcher.forward(request, response);
                }
                else if(userBean.getRole().equals("ADMIN")){
                    // add id/password to cookie to user
                    addCookiesToResponse(request,response,userBean,rememberMe);

                    //redirect admin page
                    response.sendRedirect("admin");
                }

            }
            else {
                // return user to login page with error message
            }
        }
    }

    private List<ViewCartItem> fromCartItemBeansToViewCartItems(List<CartItemBean> cartItemBeans) {
        List<ViewCartItem> viewCartItems = new ArrayList<>();
        ViewCartItem viewCartItem;
        for(CartItemBean cartItemBean: cartItemBeans){
            viewCartItem = new ViewCartItem(cartItemBean.getProductBean().getId(),cartItemBean.getRequiredQuantity());
            viewCartItems.add(viewCartItem);
        }
        return viewCartItems;
    }


    private void addCookiesToResponse(HttpServletRequest request, HttpServletResponse response,UserBean userBean,String rememberMe){

        HttpSession session = request.getSession();
        //check role to redirect to home page or admin page
        session.setAttribute("userBean", userBean);
        //create cookie for user
        if(rememberMe != null){
            // encrypt user id and password and decrypt on use
            String userId= String.valueOf(userBean.getId());
            String userPassword = userBean.getPass();

            Cookie cookieId = new Cookie("id", Util.encodeString(userId));
            Cookie cookiePassword = new Cookie("pwd", Util.encodeString(userPassword));

            //30 days for cookie age id
            cookieId.setMaxAge(60*60*24*30);
            response.addCookie(cookieId);

            //30 days for cookie age password
            cookiePassword.setMaxAge(60*60*24*30);
            response.addCookie(cookiePassword);
        }

    }
    private List<CartItemBean> mergeUserCarts(List<CartItemBean> cartItemBeanListFromJSPJson,List<CartItemBean> cartItemBeanListFromDataBase){
        List<CartItemBean> cartItemBeans = new ArrayList<>();
        cartItemBeans.addAll(cartItemBeanListFromJSPJson);
        for(CartItemBean cartItemBean: cartItemBeanListFromDataBase){
            if (!cartItemBeans.contains(cartItemBean)){
                cartItemBeans.add(cartItemBean);
            }
        }
        return cartItemBeans;
    }

}
