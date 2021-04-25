package com.example.todoservice.basicauth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Deprecated
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/basicauth")
public class BasicAuthenticationController {
    @GetMapping
    public BasicAuthenticationBean authenticate() {
        return new BasicAuthenticationBean("You are authenticated!");
    }

}
