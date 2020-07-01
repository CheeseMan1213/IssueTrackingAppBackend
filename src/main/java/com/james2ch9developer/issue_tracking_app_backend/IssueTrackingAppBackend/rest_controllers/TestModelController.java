/*
    Works Cited:
    https://github.com/RameshMF/spring-boot-tutorial/tree/master/springboot2-postgresql-jpa-hibernate-crud-example
*/

package com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend.rest_controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend.exceptions.ResourceNotFoundException;
import com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend.models.TestModel;
import com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend.repositorys.TestModelRepository;

@RestController
@RequestMapping("/testApi")
public class TestModelController {
    
    @Autowired
    private TestModelRepository testModelRepository;
    
    // Get all TestModels.
    @CrossOrigin
    @GetMapping(value = "/TestModels", produces = "application/json")
    public List<TestModel> getAllTestModels() {
        return this.testModelRepository.findAll();
    }
    
    // Get one TestModel by id.
    @GetMapping("/TestModels/{id}")
	public ResponseEntity<TestModel> getTestModelById(@PathVariable(value = "id") Long TestModelId)
	    throws ResourceNotFoundException {
	        TestModel testModel = testModelRepository.findById(TestModelId)
	            .orElseThrow(() -> new ResourceNotFoundException("TestModel not found for this id :: " + TestModelId));
	        return ResponseEntity.ok().body(testModel);
	    }
    // Save TestModel.
    @PostMapping("/TestModels")
	public TestModel createTestModel(@Valid @RequestBody TestModel testModel) {
		return testModelRepository.save(testModel);
	}
	// Update TestModel.
	@PutMapping("/TestModels/{id}")
	public ResponseEntity<TestModel> updateTestModel(@PathVariable(value = "id") Long TestModelId,
			@Valid @RequestBody TestModel testModelDetails) throws ResourceNotFoundException {
		TestModel testModel = testModelRepository.findById(TestModelId)
				.orElseThrow(() -> new ResourceNotFoundException("TestModel not found for this id :: " + TestModelId));

		testModel.setEmail(testModelDetails.getEmail());
		testModel.setLastName(testModelDetails.getLastName());
		testModel.setFirstName(testModelDetails.getFirstName());
		final TestModel updateTestModel = testModelRepository.save(testModel);
		return ResponseEntity.ok(updateTestModel);
	}
	// Delete TestModel.
	@DeleteMapping("/TestModels/{id}")
	public Map<String, Boolean> deleteTestModel(@PathVariable(value = "id") Long TestModelId)
			throws ResourceNotFoundException {
		TestModel testModel = testModelRepository.findById(TestModelId)
				.orElseThrow(() -> new ResourceNotFoundException("TestModel not found for this id :: " + TestModelId));

		testModelRepository.delete(testModel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
