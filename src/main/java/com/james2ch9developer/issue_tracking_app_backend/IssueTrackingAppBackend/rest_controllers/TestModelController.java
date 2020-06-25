package com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend.repositorys.TestModelRepository;
import com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend.models.TestModel;

@RestController
@RequestMapping("/testModel")
public class TestModelController {
    
    @Autowired
    private TestModelRepository testModelRepository;
    
    // Get all TestModels.
    @GetMapping(value = "/getAllTestModels", produces = "application/json")
    public List<TestModel> getAllTestModels() {
        return this.testModelRepository.findAll();
    }
}
