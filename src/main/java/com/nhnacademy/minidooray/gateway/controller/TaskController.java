package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.domain.TaskViewModel;
import com.nhnacademy.minidooray.gateway.service.TaskService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        taskService.getTask(taskId);

        modelMap.addAttribute("projectId", projectId);
        modelMap.addAttribute("taskId", taskId);
        return "project-task-content-form";
    }
}
