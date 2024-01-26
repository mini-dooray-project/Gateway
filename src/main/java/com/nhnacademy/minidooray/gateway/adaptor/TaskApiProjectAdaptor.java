package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.model.ProjectRequest;
import com.nhnacademy.minidooray.gateway.model.ProjectResponse;
import java.util.List;

public interface TaskApiProjectAdaptor {
    List<ProjectResponse> getProjects();

    List<ProjectResponse> getProject(Long id);

    ProjectResponse createProject(ProjectRequest request);

}
