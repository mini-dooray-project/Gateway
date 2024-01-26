package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.model.ProjectMemberRegisterRequest;
import com.nhnacademy.minidooray.gateway.model.ProjectMemberResponse;
import java.util.List;

public interface ProjectMemberAdaptor {
    List<ProjectMemberResponse> getMembers(Long projectId);

    ProjectMemberResponse createMember(ProjectMemberRegisterRequest projectMemberRegisterRequest);
}
