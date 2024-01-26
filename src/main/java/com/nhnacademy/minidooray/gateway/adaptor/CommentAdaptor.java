package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.model.CommentRequest;
import com.nhnacademy.minidooray.gateway.model.CommentResponse;
import java.util.List;

public interface CommentAdaptor {
    List<CommentResponse> getCommentByTask();

    CommentResponse createComment(CommentRequest commentRequest);


}
