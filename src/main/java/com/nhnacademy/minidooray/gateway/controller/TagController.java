package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.model.TagRequest;
import com.nhnacademy.minidooray.gateway.model.TagResponse;
import com.nhnacademy.minidooray.gateway.service.TagService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/client/projects")
public class TagController {
    private TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/{projectId}/tag")
    public String viewRegisterForm(@PathVariable Long projectId, ModelMap modelMap) {


        modelMap.addAttribute("projectId", projectId);
        return "project-tag-register-form";
    }

    @PostMapping("/{projectId}/tag")
    public String doRegisterTag(@PathVariable Long projectId, @RequestParam String tagName) {
        tagService.createTag(new TagRequest(projectId, tagName));
        String path = "redirect:/client/projects/" + projectId;
        return path;
    }

    @GetMapping("/{projectId}/tasks/{taskId}/tag")
    public String viewProjectRegisterTagForm(@PathVariable(name = "projectId") Long projectId,
                                             @PathVariable(name = "taskId") Long taskId,
                                             ModelMap modelMap) {
        List<TagResponse> list = tagService.getTagsByProjectId(projectId);
        modelMap.addAttribute("tagList", list);
        return "project-register-tag-task-form";
    }

}
