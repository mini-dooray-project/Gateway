package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.MilestoneAdaptor;
import com.nhnacademy.minidooray.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.minidooray.gateway.domain.TaskViewModel;
import com.nhnacademy.minidooray.gateway.model.TaskRequest;
import com.nhnacademy.minidooray.gateway.model.TaskResponse;
import com.nhnacademy.minidooray.gateway.model.TaskResponseByProjectId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskAdaptor taskAdaptor;
    private final MilestoneAdaptor milestoneAdaptor;
    

    public TaskServiceImpl(TaskAdaptor taskAdaptor, MilestoneAdaptor milestoneAdaptor) {
        this.taskAdaptor = taskAdaptor;
        this.milestoneAdaptor = milestoneAdaptor;
    }


    @Override
    public List<TaskViewModel> getTasks(Long projectId) {
        List<TaskResponseByProjectId> taskResponseByProjectIdList = taskAdaptor.getTestsByProjectId(projectId);
        List<TaskViewModel> taskViewModels = new ArrayList<>();
        for (TaskResponseByProjectId taskResponseByProjectId : taskResponseByProjectIdList) {
            TaskViewModel taskViewModel = new TaskViewModel(taskResponseByProjectId.getTaskId(), taskResponseByProjectId.getTaskTitle(),
                    taskResponseByProjectId.getRegistrantAccount(), taskResponseByProjectId.getMilestoneName());
            taskViewModels.add(taskViewModel);
        }
        return taskViewModels;
    }

    @Override
    public TaskViewModel getTask(Long taskId) {
        TaskResponse taskResponse = taskAdaptor.getTask(taskId);
        if (Objects.isNull(taskResponse)) {
            throw new NullPointerException();
        }

        return new TaskViewModel(taskResponse.getTaskId(), taskResponse.getTitle(),
                taskResponse.getRegistrantAccount(), taskResponse.getMilestoneName());
    }

    @Override
    public void createTask(TaskRequest taskRequest) {
        if (Objects.isNull(taskRequest)) {
            throw new NullPointerException();
        }
        taskAdaptor.createTask(taskRequest);
    }
}
