package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.*;
import com.nhnacademy.minidooray.gateway.domain.TaskRegister;
import com.nhnacademy.minidooray.gateway.domain.TaskTagDto;
import com.nhnacademy.minidooray.gateway.domain.TaskViewModel;
import com.nhnacademy.minidooray.gateway.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskAdaptor taskAdaptor;
    private final MilestoneAdaptor milestoneAdaptor;
    private final TagAdaptor tagAdaptor;
    private final TaskTagAdaptor taskTagAdaptor;
    private final CommentAdaptor commentAdaptor;

    public TaskServiceImpl(TaskAdaptor taskAdaptor, MilestoneAdaptor milestoneAdaptor, TagAdaptor tagAdaptor, TaskTagAdaptor taskTagAdaptor, CommentAdaptor commentAdaptor) {
        this.taskAdaptor = taskAdaptor;
        this.milestoneAdaptor = milestoneAdaptor;
        this.tagAdaptor = tagAdaptor;
        this.taskTagAdaptor = taskTagAdaptor;
        this.commentAdaptor = commentAdaptor;
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

    // task
    // task tag
    @Override
    public void createTask(TaskRegister taskRegister, AccountResponse account, Long projectId) {
        if (Objects.isNull(taskRegister)) {
            throw new NullPointerException();
        }
        TaskRequest taskRequest = new TaskRequest(taskRegister.getMilestone(),
                projectId, taskRegister.getTitle(), taskRegister.getContent(),
                account.getId(), taskRegister.getExpireDate());
        TaskResponse taskResponse = taskAdaptor.createTask(taskRequest);
        for (Long tagId : taskRegister.getTagId()) {
            TaskTagDto taskTagDto = new TaskTagDto(taskResponse.getTaskId(), tagId);
            taskTagAdaptor.createTaskTag(taskTagDto);
        }


    }

    @Override
    public List<TagResponse> getTagByProjectId(Long projectId) {
        return tagAdaptor.getTagByProjectId(projectId);
    }

    @Override
    public List<MilestoneResponse> getMilestones(Long projectId) {
        return milestoneAdaptor.getMilestoneByProjectId(projectId);
    }

    @Override
    public List<CommentResponse> getComments(Long taskId) {
        return commentAdaptor.getCommentByTask(taskId);
    }

    @Override
    public void createComment(RegisterComment comment, Long taskId, String registrantAccount) {
      
        CommentRequest commentRequest = new CommentRequest(taskId, registrantAccount, comment.getContent());
        commentAdaptor.createComment(commentRequest);

    }

    @Override
    public void updateComment() {
    }

    @Override
    public void deleteComment() {

    }
}
