package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.domain.MilestoneRegister;
import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.service.MilestoneService;
import com.nhnacademy.minidooray.gateway.util.CookieUtil;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(MilestoneController.class);

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

        logger.info(milestoneRegister.getMilestoneName());
        milestoneService.createMilestone(milestoneRegister, projectId);
        return "redirect:/client/projects/" + projectId;
    }

    @GetMapping("/{projectId}/milestone/view")
    public String viewMilestoneList(@PathVariable Long projectId, ModelMap modelMap) {

        modelMap.addAttribute("projectId", projectId);
        modelMap.addAttribute("milestones", milestoneService.getMilestones(projectId));
        return "project-milestone-view-form";
    }

    @PostMapping("/{projectId}/milestone/{milestoneId}/delete")
    public String doDeleteMilestone(@PathVariable(name = "projectId") Long projectId,
                                    @PathVariable(name = "milestoneId") Long milestoneId,
                                    ModelMap modelMap) {
        milestoneService.deleteMilestone(milestoneId);
        modelMap.addAttribute("projectId", projectId);
        return "redirect:/client/projects/" + projectId + "/milestone/view";
    }

}
