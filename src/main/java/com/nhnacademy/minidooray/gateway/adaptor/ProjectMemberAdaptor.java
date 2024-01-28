package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.model.ProjectMemberModifyRequest;
import com.nhnacademy.minidooray.gateway.model.ProjectMemberRegisterRequest;
import com.nhnacademy.minidooray.gateway.model.ProjectMemberResponse;
import java.util.List;

public interface ProjectMemberAdaptor {
    List<ProjectMemberResponse> getProjects(String memberId);

    List<ProjectMemberResponse> getMembers(Long projectId);

    ProjectMemberResponse createMember(ProjectMemberRegisterRequest projectMemberRegisterRequest);

    ProjectMemberResponse updateMember(String memberId, Long projectId, ProjectMemberModifyRequest request);

    Boolean authorityMember(String memberId, Long projectId);
}
