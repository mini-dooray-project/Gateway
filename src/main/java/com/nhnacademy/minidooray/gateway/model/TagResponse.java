package com.nhnacademy.minidooray.gateway.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TagResponse {
    private Long tagId;
    private Long projectId;
    private String tagName;
}
