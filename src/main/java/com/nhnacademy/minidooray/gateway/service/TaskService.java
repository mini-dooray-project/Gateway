package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.domain.Comment;
import com.nhnacademy.minidooray.gateway.domain.TaskRegister;
import com.nhnacademy.minidooray.gateway.domain.TaskViewModel;
import com.nhnacademy.minidooray.gateway.model.*;
import java.util.List;

public interface TaskService {
    List<TaskViewModel> getTasks(Long projectId);

    TaskResponse getTask(Long taskId);

    void createTask(TaskRegister taskRegister, AccountResponse account, Long projectId);

    List<TagResponse> getTagByProjectId(Long projectID);

    List<MilestoneResponse> getMilestones(Long projectId);


    List<Comment> getComments(Long taskID);
    
    CommentResponse createComment();

    CommentResponse updateComment();

    void deleteComment();


}
