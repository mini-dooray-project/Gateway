package com.nhnacademy.minidooray.gateway.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilestoneRegister {
    private String milestoneName;
    private LocalDateTime startDate;
    private LocalDateTime milestoneExpireDate;
}
