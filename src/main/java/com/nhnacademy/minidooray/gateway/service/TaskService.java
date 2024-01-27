package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.domain.Comment;
import com.nhnacademy.minidooray.gateway.domain.TaskViewModel;
import com.nhnacademy.minidooray.gateway.model.TaskRequest;
import com.nhnacademy.minidooray.gateway.model.TaskResponse;
import java.util.List;

public interface TaskService {
    List<TaskViewModel> getTasks(Long projectId);

    TaskResponse getTask(Long taskId);

    void createTask(TaskRequest taskRequest);

    List<Comment> getComments(Long taskID);


}
