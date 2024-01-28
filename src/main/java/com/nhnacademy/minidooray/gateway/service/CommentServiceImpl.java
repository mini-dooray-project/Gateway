package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.CommentAdaptor;
import com.nhnacademy.minidooray.gateway.model.CommentResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentAdaptor commentAdaptor;

    public CommentServiceImpl(CommentAdaptor commentAdaptor) {
        this.commentAdaptor = commentAdaptor;
    }

    @Override
    public List<CommentResponse> getCommentByTask(Long taskId) {
        return commentAdaptor.getCommentByTask(taskId);
    }

    @Override
    public CommentResponse createComment() {

        return null;
    }

    @Override
    public CommentResponse updateComment() {
        return null;
    }

    @Override
    public void deleteComment() {

    }
}
