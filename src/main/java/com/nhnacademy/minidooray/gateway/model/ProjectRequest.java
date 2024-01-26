package com.nhnacademy.minidooray.gateway.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProjectRequest {
    private Long statusId;
    private String projectName;
}
