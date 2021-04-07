package com.example.todoservice.welcome;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WelcomeBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }    
}
