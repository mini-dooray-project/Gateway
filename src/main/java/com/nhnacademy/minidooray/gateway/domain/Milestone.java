package com.nhnacademy.minidooray.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Milestone {
    private Long projectId;
    private String registrantAccount;
    private String content;
}
