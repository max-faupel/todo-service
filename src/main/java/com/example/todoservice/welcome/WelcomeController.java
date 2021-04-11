package com.example.todoservice.welcome;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/welcome")
public class WelcomeController {
    @GetMapping
    public WelcomeBean getWelcomeMessage() {
        // throw new RuntimeException("Error happened in REST service!");
        return new WelcomeBean("Welcome from REST service!");
    }

    @GetMapping("/{username}")
    public WelcomeBean getWelcomeMessageForUser(@PathVariable String username) {
        return new WelcomeBean(String.format("Welcome %s from REST service", username));
    }
}
