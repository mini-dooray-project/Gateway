package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.model.TagRequest;
import com.nhnacademy.minidooray.gateway.model.TagResponse;
import com.nhnacademy.minidooray.gateway.service.TagService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Slf4j
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

    @GetMapping("/{projectId}/tasks/tag")
    public String viewProjectRegisterTagForm(@PathVariable(name = "projectId") Long projectId,
                                             ModelMap modelMap) {
        List<TagResponse> tagResponses = tagService.getTagsByProjectId(projectId);
        modelMap.addAttribute("tagList", tagResponses);
        return "project-register-tag-task-form";
    }

    @GetMapping("/{projectId}/{tagId}/modify")
    public String viewModifyForm(@PathVariable(name = "projectId") Long projectId,
                                 @PathVariable(name = "tagId") Long tagId,
                                 ModelMap modelMap) {

        modelMap.addAttribute("tagId", tagId);
        modelMap.addAttribute("projectId", projectId);
        return "project-register-tag-modify-form";
    }

    @PostMapping("/{projectId}/{tagId}/modify")
    public String doModifyTag(@PathVariable(name = "projectId") Long projectId,
                              @PathVariable(name = "tagId") Long tagId,
                              TagRequest tagRequest) {
        tagService.updateTag(tagId, tagRequest);

        return "redirect:/client/projects/" + projectId + "/tasks/tag";
    }

    @PostMapping("/{projectId}/tag/{tagId}/delete")
    public String doDeleteTag(@PathVariable Long projectId,
                              @PathVariable Long tagId) {
        tagService.deleteTag(tagId);
        return "redirect:/client/projects/" + projectId + "/tasks/tag";
    }


}
