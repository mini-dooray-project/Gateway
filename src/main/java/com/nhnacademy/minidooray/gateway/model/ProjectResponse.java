package com.nhnacademy.minidooray.gateway.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProjectResponse {
    private Long projectId;
    private Long statusId;
    private String projectName;
}
