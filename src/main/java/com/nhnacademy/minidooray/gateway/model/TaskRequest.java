package com.nhnacademy.minidooray.gateway.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    Long milestoneId;
    Long projectId;
    String title;
    String content;
    String registrantAccount;
    LocalDateTime expireDate;

}
