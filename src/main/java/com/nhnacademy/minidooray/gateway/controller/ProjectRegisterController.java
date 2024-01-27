package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.model.ProjectRegisterRequest;
import com.nhnacademy.minidooray.gateway.service.ProjectService;
import com.nhnacademy.minidooray.gateway.util.CookieUtil;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/client/projects")
public class ProjectRegisterController {
    private ProjectService projectService;

    public ProjectRegisterController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/register")
    public String viewRegisterForm() {
        return "project-register-form";
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam String projectName,
                             ModelMap modelMap,
                             HttpServletRequest request) {
        Cookie cookie = CookieUtil.getCookie(request.getCookies(), "login");
        HttpSession session = request.getSession(false);
        AccountResponse account = (AccountResponse) session.getAttribute(cookie.getValue());
        ProjectRegisterRequest projectRegisterRequest = new ProjectRegisterRequest(projectName);
        projectService.createProject(projectRegisterRequest, account.getId());

        return "redirect:/";
    }
}
