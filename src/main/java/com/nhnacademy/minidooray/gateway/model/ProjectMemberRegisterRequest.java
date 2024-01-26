package com.nhnacademy.minidooray.gateway.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProjectMemberRegisterRequest {
    private String memberId;
    private Long projectId;
    private Long authorityId;
}
