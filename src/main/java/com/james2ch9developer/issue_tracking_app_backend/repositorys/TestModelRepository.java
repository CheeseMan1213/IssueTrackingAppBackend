/*
	Works Cited:
	video title = Spring Boot, PostgreSQL, JPA, Hibernate RESTful CRUD API Tutorial
	URL = https://www.youtube.com/watch?v=eWbGV3LLwVQ
    https://github.com/RameshMF/spring-boot-tutorial/tree/master/springboot2-postgresql-jpa-hibernate-crud-example
*/

package com.james2ch9developer.issue_tracking_app_backend.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.james2ch9developer.issue_tracking_app_backend.models.TestModel;

@Repository
public interface TestModelRepository extends JpaRepository<TestModel, Long> {
    //
}