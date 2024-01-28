package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.minidooray.gateway.adaptor.ProjectMemberAdaptor;
import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.model.ProjectMemberRegisterRequest;
import com.nhnacademy.minidooray.gateway.model.ProjectMemberResponse;
import com.nhnacademy.minidooray.gateway.model.RegisterProjectMember;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    private ProjectMemberAdaptor memberAdaptor;
    private AccountAdaptor accountAdaptor;

    public ProjectMemberServiceImpl(ProjectMemberAdaptor memberAdaptor, AccountAdaptor accountAdaptor) {
        this.memberAdaptor = memberAdaptor;
        this.accountAdaptor = accountAdaptor;
    }

    @Override
    public List<ProjectMemberResponse> getProjectMembers(Long projectId) {

        return memberAdaptor.getMembersByProjectId(projectId);
    }

    @Override
    public List<ProjectMemberResponse> getProjects(String accountId) {
        return memberAdaptor.getMembersByMemberId(accountId);
    }

    @Override
    public void registerProjectMember(RegisterProjectMember registerProjectMember, Long projectId) {
        ProjectMemberRegisterRequest request = new ProjectMemberRegisterRequest(registerProjectMember.getAccountId(),
                projectId, 2L);

        memberAdaptor.createMember(request);
    }


    @Override
    public boolean existMember(String accountId) {
        AccountResponse accountResponse = accountAdaptor.getAccount(accountId);
        return Objects.nonNull(accountResponse);

    }

    @Override
    public Boolean authorityMember(String memberId, Long projectId) {
//        return projectMemberAdaptor.authorityMember(memberId, projectId);
        return false;
    }
}
