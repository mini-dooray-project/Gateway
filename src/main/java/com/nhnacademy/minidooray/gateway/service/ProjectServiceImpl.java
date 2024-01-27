package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.minidooray.gateway.adaptor.ProjectMemberAdaptor;
import com.nhnacademy.minidooray.gateway.domain.Project;
import com.nhnacademy.minidooray.gateway.model.ProjectRegisterRequest;
import com.nhnacademy.minidooray.gateway.model.ProjectRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectAdaptor projectAdaptor;
    private final ProjectMemberAdaptor projectMemberAdaptor;

    /**
     * create에 넣어야 할 것
     * project
     * project status
     * project member
     *
     * @param projectRegisterRequest
     */
    @Override
    public void createProject(ProjectRegisterRequest projectRegisterRequest) {
        ProjectRequest projectRequest = new ProjectRequest();
        projectAdaptor.createProject(projectRequest);
    }

    @Override
    public List<Project> participationProject() {
        return null;
    }
}
