package com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend;

/* The package name is long, but basically my usual 'com.main' is eual to this ->
com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend

In a previous Spring-boot project a package named rest_controllers, so for this project it is ->
com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend.rest_controllers
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IssueTrackingAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueTrackingAppBackendApplication.class, args);
	}

}
