package com.example.rest.todo.welcome;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WelcomeController {
    @RequestMapping(method = RequestMethod.GET, path = "/welcome")
    public WelcomeBean getWelcomeMessage() {
        throw new RuntimeException("Error happened in REST service!");
        // return new WelcomeBean("Welcome from REST service!");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/welcome/{username}")
    public WelcomeBean getWelcomeMessageForUser(@PathVariable String username) {
        return new WelcomeBean(String.format("Welcome %s from REST service", username));
    }
}
