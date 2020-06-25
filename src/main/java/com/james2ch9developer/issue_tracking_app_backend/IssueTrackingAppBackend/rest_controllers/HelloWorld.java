package com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class HelloWorld {
    
    @GetMapping(value = "/hello", produces = "text/plain")
    public String HelloWorld() {
        return "Hello World! La La La.";
    }
}
