package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client/projects")
public class ProjectRegisterController {
    private ProjectService projectService;

    public ProjectRegisterController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String viewRegisterForm() {
        return "project-register-form";
    }
}
