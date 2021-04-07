package com.example.rest.todo.welcome;

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
