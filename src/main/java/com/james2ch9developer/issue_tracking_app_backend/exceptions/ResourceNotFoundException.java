/*
	Works Cited:
	video title = Spring Boot, PostgreSQL, JPA, Hibernate RESTful CRUD API Tutorial
	URL = https://www.youtube.com/watch?v=eWbGV3LLwVQ
    https://github.com/RameshMF/spring-boot-tutorial/tree/master/springboot2-postgresql-jpa-hibernate-crud-example
*/

package com.james2ch9developer.issue_tracking_app_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
