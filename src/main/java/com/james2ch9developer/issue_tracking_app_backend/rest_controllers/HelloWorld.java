package com.james2ch9developer.issue_tracking_app_backend.rest_controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloWorld {
    
    @GetMapping(value = "/hello", produces = "text/plain")
    public String sayHello() {
        return "Hello World! La La La.\nHello World to you too!\nRarity and Sweetie Bell";
    }
}
