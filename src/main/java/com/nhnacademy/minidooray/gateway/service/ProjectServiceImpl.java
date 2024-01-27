package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.minidooray.gateway.adaptor.ProjectMemberAdaptor;
import com.nhnacademy.minidooray.gateway.domain.Project;
import com.nhnacademy.minidooray.gateway.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectAdaptor projectAdaptor;
    private final ProjectMemberAdaptor projectMemberAdaptor;


    public ProjectServiceImpl(ProjectAdaptor projectAdaptor, ProjectMemberAdaptor projectMemberAdaptor) {
        this.projectAdaptor = projectAdaptor;
        this.projectMemberAdaptor = projectMemberAdaptor;

    }

    @Override
    public List<Project> participationProject(AccountResponse response) {
        List<Project> projects = new ArrayList<>();
        List<ProjectMemberResponse> projectMemberResponses = projectMemberAdaptor.getProjects(response.getId());
        for (ProjectMemberResponse memberResponse : projectMemberResponses) {
            ProjectResponse projectResponse = projectAdaptor.getProject(memberResponse.getProjectId());
            projects.add(new Project(projectResponse.getProjectId(), projectResponse.getProjectName(),
                    projectResponse.getStatusId(), memberResponse.getAuthorityName()));
        }
        return projects;
    }


    @Override
    public void createProject(ProjectRequest projectRequest, String accountId) {
        if (Objects.isNull(projectRequest)) {
            throw new NullPointerException("project request null");
        }

        projectRequest.setStatusId(1L);
        ProjectResponse response = projectAdaptor.createProject(projectRequest);
        ProjectMemberRegisterRequest request = new ProjectMemberRegisterRequest(accountId, response.getProjectId(), response.getStatusId());
        projectMemberAdaptor.createMember(request);
    }
}
