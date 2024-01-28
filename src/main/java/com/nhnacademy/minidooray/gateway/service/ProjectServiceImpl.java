package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.minidooray.gateway.adaptor.ProjectMemberAdaptor;
import com.nhnacademy.minidooray.gateway.domain.Project;
import com.nhnacademy.minidooray.gateway.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
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
        List<ProjectMemberResponse> projectMemberResponses = projectMemberAdaptor.getMembersByMemberId(response.getId());
        for (ProjectMemberResponse memberResponse : projectMemberResponses) {
            ProjectResponse projectResponse = projectAdaptor.getProject(memberResponse.getProjectId());
            projects.add(new Project(projectResponse.getProjectId(), projectResponse.getProjectName(),
                    projectResponse.getStatusId(), memberResponse.getAuthorityName()));
        }
        return projects;
    }


    @Override
    public void createProject(ProjectRegisterRequest projectRegisterRequest, String accountId) {
        if (Objects.isNull(projectRegisterRequest)) {
            throw new NullPointerException("project request null");
        }
        ProjectRequest projectRequest = new ProjectRequest(1L, projectRegisterRequest.getProjectName());
        ProjectResponse response = projectAdaptor.createProject(projectRequest);
        log.info("value:{}", response);
        ProjectMemberRegisterRequest request = new ProjectMemberRegisterRequest(accountId, response.getProjectId(), response.getStatusId());
        projectMemberAdaptor.createMember(request);
    }
}
