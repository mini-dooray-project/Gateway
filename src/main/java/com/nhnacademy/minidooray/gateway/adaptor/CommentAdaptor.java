package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.model.CommentRequest;
import com.nhnacademy.minidooray.gateway.model.CommentResponse;
import com.nhnacademy.minidooray.gateway.model.DeleteResponse;
import java.util.List;

public interface CommentAdaptor {
    List<CommentResponse> getCommentByTask(Long taskId);

    CommentResponse createComment(CommentRequest commentRequest);

    CommentResponse updateComment(Long taskId, CommentRequest commentRequest);

    DeleteResponse deleteComment(Long taskId);

}
