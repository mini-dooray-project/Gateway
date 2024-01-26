package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.model.ProjectRegisterRequest;

public interface ProjectService {
    void createProject(ProjectRegisterRequest projectRegisterRequest);
}
