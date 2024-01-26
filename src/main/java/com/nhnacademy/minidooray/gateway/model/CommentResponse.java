package com.nhnacademy.minidooray.gateway.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CommentResponse {
    private Long commentId;
    private Long taskId;
    private String registrantAccount;
    private LocalDateTime createdDate;
    private String content;
}
