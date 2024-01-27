package com.nhnacademy.minidooray.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskViewModel {
    private Long taskId;
    private String taskTitle;
    private String registrantAccount;
    private String milestoneName;
}
