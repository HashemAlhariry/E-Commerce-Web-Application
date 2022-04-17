package com.ecommerce.presentation.controllers;

import com.ecommerce.utils.CommonString;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AcceptPaymentServlet", urlPatterns = {"/AcceptPaymentServlet"})
public class AcceptPaymentServlet extends HttpServlet {

    public AcceptPaymentServlet(){

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        HttpSession session = request.getSession(false);


        try {

            Stripe.apiKey = getServletContext().getInitParameter("stripeSecretKey");
            Map<String, String[]> httpParameters = request.getParameterMap();
            Map<String, Object> userBillingData = new HashMap<>();
            String userEmail = httpParameters.get("stripeEmail")[0];
            userBillingData.put("email", userEmail);
            userBillingData.put("stripeToken", httpParameters.get("stripeToken")[0]);
            Map<String, Object> params = new HashMap<>();
            params.put("amount", session.getAttribute("total"));
            params.put("currency", "egp");
            params.put("source", userBillingData.get("stripeToken"));
            params.put("receipt_email", session.getAttribute("userEmail"));
            Charge charge;
            charge = Charge.create(params);

            // example of charge id chargeID ch_3KnqbQJKNiBLygtk1W75evrE
            String chargeID = charge.getId();
            // save later to db

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "order-successfully.jsp");
            requestDispatcher.forward(request, response);



        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }



}