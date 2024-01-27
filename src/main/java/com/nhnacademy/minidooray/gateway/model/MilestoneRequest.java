package com.nhnacademy.minidooray.gateway.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MilestoneRequest {
    private Long projectId;
    private String milestoneName;
    private LocalDateTime startDate;
    private LocalDateTime milestoneExpireDate;
}
