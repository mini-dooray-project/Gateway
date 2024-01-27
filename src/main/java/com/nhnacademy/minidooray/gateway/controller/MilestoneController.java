package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.service.MilestoneService;
import com.nhnacademy.minidooray.gateway.util.CookieUtil;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client/projects/milestone")
public class MilestoneController {
    private MilestoneService milestoneService;

    public MilestoneController(MilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }

    @GetMapping
    public String viewMilestone() {

        return "project-milestone-register-form";
    }

    @PostMapping
    public String doMilestoneRegister(HttpServletRequest request,
                                      MilestoneRegister milestoneRegister,
                                      ModelMap modelMap) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getCookie(request.getCookies(), "login");
        AccountResponse accountResponse = (AccountResponse) session.getAttribute(cookie.getValue());


        return "redirect:/";
    }


}
