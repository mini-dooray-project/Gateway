package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.model.ProjectRequest;
import com.nhnacademy.minidooray.gateway.model.ProjectResponse;
import java.util.List;

public interface ProjectAdaptor {
    List<ProjectResponse> getProjects();

    ProjectResponse getProject(Long id);

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(ProjectRequest projectRequest);

}
