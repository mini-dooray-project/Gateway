package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.model.RegisterProjectMember;
import com.nhnacademy.minidooray.gateway.service.ProjectMemberService;
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
public class ProjectMemberController {
    private ProjectMemberService projectMemberService;

    public ProjectMemberController(ProjectMemberService projectMemberService) {
        this.projectMemberService = projectMemberService;
    }

    @GetMapping("/{projectId}/member")
    public String viewProjectMember(@PathVariable Long projectId, ModelMap modelMap) {
        modelMap.addAttribute("projectId", projectId);
        modelMap.addAttribute("projectMembers", projectMemberService.getProjectMembers(projectId));
        return "project-member-form";
    }

    @GetMapping("/{projectId}/member/register")
    public String viewRegisterProjectMember(@PathVariable Long projectId) {
        return "project-member-register-form";
    }

    @PostMapping("/{projectId}/member/register")
    public String registerProjectMember(@PathVariable Long projectId,
                                        RegisterProjectMember registerProjectMember) {

        String accountId = registerProjectMember.getAccountId();
        log.info("======> value:{}", accountId);
        if (!projectMemberService.existMember(accountId)) {
            return "redirect:/client/projects/" + projectId + "/member/register";
        }

        projectMemberService.registerProjectMember(registerProjectMember, projectId);
        return "redirect:/client/projects/" + projectId;
    }
}
