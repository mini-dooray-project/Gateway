package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.ProjectMemberAdaptor;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberAdaptor projectMemberAdaptor;

    public ProjectMemberServiceImpl(ProjectMemberAdaptor projectMemberAdaptor) {
        this.projectMemberAdaptor = projectMemberAdaptor;
    }

    @Override
    public Boolean authorityMember(String memberId, Long projectId) {
        return projectMemberAdaptor.authorityMember(memberId, projectId);
    }
}
