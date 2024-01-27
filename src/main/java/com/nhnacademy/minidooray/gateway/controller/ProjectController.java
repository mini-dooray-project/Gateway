package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.domain.Project;
import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.service.ProjectService;
import com.nhnacademy.minidooray.gateway.util.CookieUtil;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String viewProjectList(HttpServletRequest request, ModelMap modelMap) {
        Cookie cookie = CookieUtil.getCookie(request.getCookies(), "login");
        HttpSession session = request.getSession(false);
        AccountResponse account = (AccountResponse) session.getAttribute(cookie.getValue());
        List<Project> projects = projectService.participationProject(account);
        modelMap.addAttribute("projects", projects);

        return "project-list-form";
    }

    @GetMapping("/{projectId}")
    public String viewProject(
            @PathVariable Long projectId,
            HttpServletRequest request, ModelMap modelMap) {
        // project ID로 해당 테스크
        Cookie cookie = CookieUtil.getCookie(request.getCookies(), "login");
        HttpSession session = request.getSession(false);
        AccountResponse account = (AccountResponse) session.getAttribute(cookie.getValue());
        List<Project> projects = projectService.participationProject(account);
        modelMap.addAttribute("projects", projects);

        return "project-task-form";
    }

    @PostMapping
    public String viewProjects(HttpServletRequest request,
                               ModelMap modelMap) {
        HttpSession session = request.getSession(false);
        log.info(session.getId());
        Cookie cookie = CookieUtil.getCookie(request.getCookies(), "login");
        log.info("value:{}", cookie.getValue());
        if (Objects.isNull(session.getAttribute(cookie.getValue()))) {
            throw new NullPointerException();
        }
        AccountResponse account = (AccountResponse) session.getAttribute(cookie.getValue());
        List<Project> projects = projectService.participationProject(account);
        modelMap.addAttribute("projects", projects);
        return "main";
    }


}
