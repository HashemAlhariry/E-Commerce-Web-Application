package com.ecommerce.exceptions;

import java.io.IOException;

public class IllegalInputException extends IOException {


    private String message = "your input is illegal..";

    public IllegalInputException() {
        super();
    }

    public IllegalInputException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
