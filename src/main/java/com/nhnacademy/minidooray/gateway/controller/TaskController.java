package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.domain.TaskViewModel;
import com.nhnacademy.minidooray.gateway.model.MilestoneResponse;
import com.nhnacademy.minidooray.gateway.model.TagResponse;
import com.nhnacademy.minidooray.gateway.model.TaskResponse;
import com.nhnacademy.minidooray.gateway.service.TaskService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/client/projects")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{projectId}")
    public String viewTasks(@PathVariable Long projectId, ModelMap modelMap) {
        List<TaskViewModel> taskViewModelList = taskService.getTasks(projectId);
        log.info("task view model:{}", taskViewModelList);

        modelMap.addAttribute("projectId", projectId);
        modelMap.addAttribute("tasks", taskViewModelList);
        return "project-task-form";
    }

    @GetMapping("/{projectId}/tasks/{taskId}")
    public String viewTaskContent(@PathVariable(name = "projectId") Long projectId,
                                  @PathVariable(name = "taskId") Long taskId,
                                  ModelMap modelMap) {
        TaskResponse taskResponse = taskService.getTask(taskId);

        modelMap.addAttribute("task", taskResponse);
        modelMap.addAttribute("projectId", projectId);
        modelMap.addAttribute("taskId", taskId);
        return "project-task-content-form";
    }

    @GetMapping("/{projectId}/tasks/register")
    public String viewRegisterForm(@PathVariable Long projectId,
                                   ModelMap modelMap) {

        List<TagResponse> tagResponses = taskService.getTagByProjectId(projectId);
        List<MilestoneResponse> milestoneResponses = taskService.getMilestones(projectId);
        modelMap.addAttribute("tagList", tagResponses);
        modelMap.addAttribute("milestones", milestoneResponses);
        return "project-task-register-form";
    }

    @PostMapping("/{projectId}/tasks/register")
    public String doRegisterTask(@PathVariable Long projectId,
                                 ModelMap modelMap) {
//        taskService.createTask();

        return "redirect:/";
    }
}
