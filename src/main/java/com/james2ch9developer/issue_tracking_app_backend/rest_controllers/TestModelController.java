/*
    Works Cited:
    video title = Spring Boot, PostgreSQL, JPA, Hibernate RESTful CRUD API Tutorial
    URL = https://www.youtube.com/watch?v=eWbGV3LLwVQ
    https://github.com/RameshMF/spring-boot-tutorial/blob/master/springboot2-postgresql-jpa-hibernate-crud-example/src/main/java/net/guides/springboot2/crud/controller/EmployeeController.java
*/

package com.james2ch9developer.issue_tracking_app_backend.rest_controllers;

import com.james2ch9developer.issue_tracking_app_backend.exceptions.ResourceNotFoundException;
import com.james2ch9developer.issue_tracking_app_backend.models.TestModel;
import com.james2ch9developer.issue_tracking_app_backend.repositorys.TestModelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

@RestController
@RequestMapping("/testApi")
// I am suppressing this warning because this is a Spring-boot rest controller.
// This class does not need a constructor, and I do not need PMD telling me otherwise.
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class TestModelController {

	//The only reason the Java transient keyword is here, is to appease the PMD style checker.
	//See this webpage for a better definition = https://stackoverflow.com/questions/2154622/why-does-jpa-have-a-transient-annotation
	@Autowired
	transient private TestModelRepository testModelRepository;

	/*
	Special info from:
	https://stackoverflow.com/questions/14197359/spring-cache-abstraction-vs-interfaces-vs-key-param-null-key-returned-for-cach
	http://static.springsource.org/spring/docs/3.1.0.M1/spring-framework-reference/html/cache.html#cache-spel-context
	The '#p0' is part of Spring, and is a different way to reference the URL parameters.

	Helpful URL = https://stackoverflow.com/questions/33383366/cacheble-annotation-on-no-parameter-method
	"The easiest workaround is to provide the name of the method as the key"
	 */
	// Get all TestModels.
	@CrossOrigin
	@GetMapping(value = "/TestModels", produces = "application/json")
	@Cacheable(key = "#root.methodName", value = "TestModels")
	public List<TestModel> getAllTestModels() {
		return this.testModelRepository.findAll();
	}

	/** Get one TestModel by id. */
	@GetMapping("/TestModels/{id}")
	public ResponseEntity<TestModel> getTestModelById(@PathVariable(value = "id") final Long testModelId)
	  throws ResourceNotFoundException {
		final TestModel testModel = testModelRepository.findById(testModelId)
		  .orElseThrow(() -> new ResourceNotFoundException("TestModel not found for this id :: " + testModelId));
		return ResponseEntity.ok().body(testModel);
	}

	/** Save TestModel. */
	@PostMapping("/TestModels")
	public TestModel createTestModel(@Valid @RequestBody final TestModel testModel) {
		return testModelRepository.save(testModel);
	}

	/** Update TestModel. */
	@PutMapping("/TestModels/{id}")
	public ResponseEntity<TestModel> updateTestModel(@PathVariable(value = "id") final Long testModelId,
	                                                 @Valid @RequestBody final TestModel testModelDetails) throws ResourceNotFoundException {
		final TestModel testModel = testModelRepository.findById(testModelId)
		  .orElseThrow(() -> new ResourceNotFoundException("TestModel not found for this id :: " + testModelId));

		testModel.setEmail(testModelDetails.getEmail());
		testModel.setLastName(testModelDetails.getLastName());
		testModel.setFirstName(testModelDetails.getFirstName());
		final TestModel updateTestModel = testModelRepository.save(testModel);
		return ResponseEntity.ok(updateTestModel);
	}

	/** Delete TestModel by id. */
	@DeleteMapping("/TestModels/{id}")
	public Map<String, Boolean> deleteTestModel(@PathVariable(value = "id") final Long testModelId)
	  throws ResourceNotFoundException {
		final TestModel testModel = testModelRepository.findById(testModelId)
		  .orElseThrow(() -> new ResourceNotFoundException("TestModel not found for this id :: " + testModelId));

		testModelRepository.delete(testModel);
		final Map<String, Boolean> response = new ConcurrentHashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

