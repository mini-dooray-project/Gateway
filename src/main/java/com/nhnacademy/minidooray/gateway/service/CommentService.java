package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.model.CommentResponse;
import java.util.List;

public interface CommentService {
    List<CommentResponse> getCommentByTask(Long taskId);

    CommentResponse createComment();

    CommentResponse updateComment();

    void deleteComment();
}
