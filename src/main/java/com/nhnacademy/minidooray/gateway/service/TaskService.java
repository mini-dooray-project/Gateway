package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.domain.TaskViewModel;
import com.nhnacademy.minidooray.gateway.model.TaskRequest;
import java.util.List;

public interface TaskService {
    List<TaskViewModel> getTasks(Long projectId);

    TaskViewModel getTask(Long taskId);

    void createTask(TaskRequest taskRequest);


}
