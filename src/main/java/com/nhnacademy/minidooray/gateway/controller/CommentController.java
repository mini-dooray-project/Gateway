package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.model.RegisterComment;
import com.nhnacademy.minidooray.gateway.service.TaskService;
import com.nhnacademy.minidooray.gateway.util.CookieUtil;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client/projects")
public class CommentController {
    private final TaskService taskService;

    public CommentController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/{projectId}/tasks/{taskId}/comment")
    public String doRegisterComment(@PathVariable(name = "taskId") Long taskId,
                                    @PathVariable(name = "projectId") Long projectId,
                                    RegisterComment registerComment,
                                    HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Cookie cookie = CookieUtil.getCookie(request.getCookies(), "login");
        AccountResponse accountResponse = (AccountResponse) session.getAttribute(cookie.getValue());

        taskService.createComment(registerComment, taskId, accountResponse.getId());
        return "redirect:/client/projects/" + projectId + "/tasks/" + taskId;
    }
}
