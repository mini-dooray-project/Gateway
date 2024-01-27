package com.nhnacademy.minidooray.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberResponse {
    private String memberId;
    private Long projectId;
    private String projectName;
    private Long authorityId;
    private String authorityName;
}
