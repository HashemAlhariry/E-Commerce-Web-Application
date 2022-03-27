package com.ecommerce.utils;
import jakarta.servlet.http.Cookie;
import java.util.Optional;
public class CookieUtil {
    private static final CookieUtil INSTANCE =new CookieUtil();
    private CookieUtil(){

    }

    public static CookieUtil getInstance(){
        return INSTANCE;
    }

    public Optional<Cookie> getCookieByName(Cookie[]cookies, String name){
        Optional<Cookie>optionalCookie=Optional.empty();
        for(Cookie cookie:cookies){
            String cookieName= cookie.getName();
            if(cookieName.equals(name)){
                optionalCookie=Optional.of(cookie);
                break;
            }
        }
        return optionalCookie;
    }

}