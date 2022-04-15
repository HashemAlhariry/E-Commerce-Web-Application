package com.ecommerce.handlers;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

import java.util.UUID;

@WebListener
public class HttpRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        String reqId = UUID.randomUUID().toString();
        req.setAttribute("reqId", reqId);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        String reqId = (String) req.getAttribute("reqId");
        EntityMangerUtil.getInstance().closeEntityManager(reqId);
    }


}
