package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.minidooray.gateway.adaptor.ProjectMemberAdaptor;
import com.nhnacademy.minidooray.gateway.domain.Project;
import com.nhnacademy.minidooray.gateway.model.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectAdaptor projectAdaptor;
    private final ProjectMemberAdaptor projectMemberAdaptor;

    public ProjectServiceImpl(ProjectAdaptor projectAdaptor, ProjectMemberAdaptor projectMemberAdaptor) {
        this.projectAdaptor = projectAdaptor;
        this.projectMemberAdaptor = projectMemberAdaptor;
    }

    // 리스트로 다 가져와서 처리?
    // 아니면 하나씩 처리?
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
}
