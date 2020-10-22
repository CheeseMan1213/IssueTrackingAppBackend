package com.james2ch9developer.issue_tracking_app_backend.rest_controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
// I am suppressing this warning because this is a Spring-boot rest controller.
// This class does not need a constructor, and I do not need PMD telling me otherwise.
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class HelloWorld {
    
    @GetMapping(value = "/hello", produces = "text/plain")
    public String sayHello() {
        return "Hello World! La La La.\nHello World to you too!\nLuster Dawn";
    }
}
