package com.ecommerce;

import com.ecommerce.utils.MailUtil;
import org.apache.commons.mail.EmailException;

import java.net.MalformedURLException;

public class MailTest {
    public static void main(String[] args) {
        try {
            MailUtil.getInstance().sendAddContactMail("ahmedosamam03@gmail.com","015");
        } catch (EmailException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
