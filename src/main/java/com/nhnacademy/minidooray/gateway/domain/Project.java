package com.nhnacademy.minidooray.gateway.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Project {
    private Long projectId;
    private String projectName;
    private String status;
}
