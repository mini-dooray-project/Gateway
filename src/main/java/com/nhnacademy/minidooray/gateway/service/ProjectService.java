package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.domain.Project;
import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.model.ProjectRegisterRequest;
import java.util.List;

public interface ProjectService {
    List<Project> participationProject(AccountResponse response);

    void createProject(ProjectRegisterRequest projectRequest, String accountId);
}
