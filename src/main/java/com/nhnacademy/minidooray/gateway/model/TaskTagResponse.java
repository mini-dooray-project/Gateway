package com.nhnacademy.minidooray.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskTagResponse {
    private Long taskId;
    private Long tagId;
    String taskName;
}
