package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.model.DeleteResponse;
import com.nhnacademy.minidooray.gateway.model.TaskRequest;
import com.nhnacademy.minidooray.gateway.model.TaskResponse;
import com.nhnacademy.minidooray.gateway.model.TaskResponseByProjectId;
import java.util.List;

public interface TaskAdaptor {
    List<TaskResponse> getTasks();

    List<TaskResponseByProjectId> getTestsByProjectId(Long projectId);

    TaskResponse getTask(Long taskId);

    TaskResponse createTask(TaskRequest request);

    TaskResponse updateTask(Long taskId, TaskRequest request);

    DeleteResponse deleteTask(Long taskId);
}
