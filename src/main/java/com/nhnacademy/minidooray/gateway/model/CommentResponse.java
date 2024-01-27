package com.nhnacademy.minidooray.gateway.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {
    private Long commentId;
    private Long taskId;
    private String registrantAccount;
    private LocalDateTime createdDate;
    private String content;
}
