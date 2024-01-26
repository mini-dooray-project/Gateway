package com.nhnacademy.minidooray.gateway.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProjectMemberResponse {
    private String memberId;
    private Long projectId;
    private String projectName;
    private Long authorityId;
    private String authorityName;
}
