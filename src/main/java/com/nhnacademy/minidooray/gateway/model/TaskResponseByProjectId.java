package com.nhnacademy.minidooray.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseByProjectId {
    private Long taskId;
    private String taskTitle;
    private String registrantAccount;
    private String milestoneName;
}
