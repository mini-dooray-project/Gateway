package com.nhnacademy.minidooray.gateway.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CommentRequest {
    private Long taskId;
    private String registrantAccount;
    private String content;

}
