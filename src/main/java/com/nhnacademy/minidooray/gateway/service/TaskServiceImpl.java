package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.MilestoneAdaptor;
import com.nhnacademy.minidooray.gateway.adaptor.TagAdaptor;
import com.nhnacademy.minidooray.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.minidooray.gateway.domain.Comment;
import com.nhnacademy.minidooray.gateway.domain.TaskRegister;
import com.nhnacademy.minidooray.gateway.domain.TaskViewModel;
import com.nhnacademy.minidooray.gateway.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskAdaptor taskAdaptor;
    private final MilestoneAdaptor milestoneAdaptor;
    private final TagAdaptor tagAdaptor;

    public TaskServiceImpl(TaskAdaptor taskAdaptor, MilestoneAdaptor milestoneAdaptor, TagAdaptor tagAdaptor) {
        this.taskAdaptor = taskAdaptor;
        this.milestoneAdaptor = milestoneAdaptor;
        this.tagAdaptor = tagAdaptor;
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
    public TaskResponse getTask(Long taskId) {
        TaskResponse taskResponse = taskAdaptor.getTask(taskId);
        if (Objects.isNull(taskResponse)) {
            throw new NullPointerException();
        }
        return taskResponse;
    }

    @Override
    public void createTask(TaskRegister taskRegister) {
        if (Objects.isNull(taskRegister)) {
            throw new NullPointerException();
        }
        TaskRequest taskRequest = new TaskRequest();
        taskAdaptor.createTask(taskRequest);
    }

    @Override
    public List<Comment> getComments(Long taskID) {
        return null;
    }

    @Override
    public List<TagResponse> getTagByProjectId(Long projectId) {
        return tagAdaptor.getTagByProjectId(projectId);
    }

    @Override
    public List<MilestoneResponse> getMilestones(Long projectId) {
        return milestoneAdaptor.getMilestoneByProjectId(projectId);
    }
}
