package com.nhnacademy.minidooray.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskTagDto {
    private Long taskId;
    private Long tagId;
}
