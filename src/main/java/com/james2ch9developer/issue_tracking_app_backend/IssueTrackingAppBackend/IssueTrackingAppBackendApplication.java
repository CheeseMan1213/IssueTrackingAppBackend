package com.james2ch9developer.issue_tracking_app_backend;

/* The package name is long, but basically my usual 'com.main' is equal to this ->
com.james2ch9developer.issue_tracking_app_backend

In a previous Spring-boot project a package named rest_controllers, so for this project it is ->
com.james2ch9developer.issue_tracking_app_backend.rest_controllers

I do not remember how I got 2 directories with basically the same name, one with underscores
that is all lowercase, followed by one that is uppercase camel case.
But it happened, so roll with it.
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching // This is a new annotaiotn I added after I started using Redis cache.
public class IssueTrackingAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueTrackingAppBackendApplication.class, args);
	}

}
