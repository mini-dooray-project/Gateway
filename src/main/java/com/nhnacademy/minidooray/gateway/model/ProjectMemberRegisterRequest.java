package com.nhnacademy.minidooray.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ProjectMemberRegisterRequest {
    private String memberId;
    private Long projectId;
    private Long authorityId;
}
