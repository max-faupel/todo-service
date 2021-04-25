package com.example.todoservice.basicauth;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Deprecated
public class BasicAuthenticationBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
