package com.nhnacademy.minidooray.gateway.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilestoneRequest {
    private Long projectId;
    private String milestoneName;
    private LocalDateTime startDate;
    private LocalDateTime milestoneExpireDate;

}
