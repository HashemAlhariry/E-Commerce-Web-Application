package com.ecommerce.utils;

import jakarta.servlet.http.Cookie;

import java.util.Optional;

public class CookieUtil {
    Optional<Cookie> getCookieByName(Cookie[]cookies, String name){
        Optional<Cookie>optionalCookie=Optional.empty();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals(name)){
                optionalCookie=Optional.of(cookie);
                break;
            }
        }
        return optionalCookie;
    }
}
