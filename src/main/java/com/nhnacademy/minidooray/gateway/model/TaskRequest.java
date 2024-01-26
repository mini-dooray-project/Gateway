package com.nhnacademy.minidooray.gateway.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TaskRequest {
    Long milestoneId;
    Long projectId;
    String title;
    String content;
    String registrantAccount;
    LocalDateTime expireDate;

}
