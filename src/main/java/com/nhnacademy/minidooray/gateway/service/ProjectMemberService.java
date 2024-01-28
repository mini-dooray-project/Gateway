package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.model.ProjectMemberResponse;
import com.nhnacademy.minidooray.gateway.model.RegisterProjectMember;
import java.util.List;

public interface ProjectMemberService {
    List<ProjectMemberResponse> getProjectMembers(Long projcetId);

    List<ProjectMemberResponse> getProjects(String accountId);

    void registerProjectMember(RegisterProjectMember projectMemberRegisterRequest, Long projectId);
    Boolean authorityMember(String memberId, Long projectId);


    boolean existMember(String accountId);


}
