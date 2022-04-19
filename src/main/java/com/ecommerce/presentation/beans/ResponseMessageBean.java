package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ResponseMessageBean {
    private String state;
    private List<String> messages;

    public ResponseMessageBean(){}

    public ResponseMessageBean(String state, List<String> messages) {
        this.state = state;
        this.messages = messages;
    }
}
