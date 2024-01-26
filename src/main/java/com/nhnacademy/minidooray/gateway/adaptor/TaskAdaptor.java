package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.model.TaskRequest;
import com.nhnacademy.minidooray.gateway.model.TaskResponse;
import java.util.List;

public interface TaskAdaptor {
    List<TaskResponse> getTasks();

    TaskResponse getTask();

    TaskResponse createTask(TaskRequest request);
}
