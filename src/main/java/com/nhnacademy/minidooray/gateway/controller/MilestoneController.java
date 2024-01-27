package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.domain.MilestoneRegister;
import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.service.MilestoneService;
import com.nhnacademy.minidooray.gateway.util.CookieUtil;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client/projects")
public class MilestoneController {
    private MilestoneService milestoneService;

    public MilestoneController(MilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }

    @GetMapping("/{projectId}/milestone")
    public String viewMilestone(@PathVariable Long projectId,
                                ModelMap modelMap) {
        modelMap.addAttribute("projectId", projectId);
        return "project-milestone-register-form";
    }

    @PostMapping("/{projectId}/milestone")
    public String doMilestoneRegister(@PathVariable Long projectId,
                                      HttpServletRequest request,
                                      MilestoneRegister milestoneRegister,
                                      ModelMap modelMap) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getCookie(request.getCookies(), "login");
        AccountResponse accountResponse = (AccountResponse) session.getAttribute(cookie.getValue());

        milestoneService.createMilestone(milestoneRegister, projectId);
        return "redirect:/client/projects/" + projectId;
    }


}
