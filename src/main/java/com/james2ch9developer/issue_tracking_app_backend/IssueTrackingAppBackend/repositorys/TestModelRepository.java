package com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.james2ch9developer.issue_tracking_app_backend.IssueTrackingAppBackend.models.TestModel;

@Repository
public interface TestModelRepository extends JpaRepository<TestModel, Long> {
    //
}