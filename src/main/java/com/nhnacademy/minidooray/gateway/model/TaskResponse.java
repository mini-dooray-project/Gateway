package com.nhnacademy.minidooray.gateway.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TaskResponse {
    private Long taskId;
    private String title;
    private String content;
    private String registrantAccount;
    private LocalDateTime createdDate;
    private LocalDateTime expireDate;

    private Long projectId;

    // milestone
    private Long milestoneId;
    private String milestoneName;
    private LocalDateTime startDate;
    private LocalDateTime milestoneExpireDate;

}
