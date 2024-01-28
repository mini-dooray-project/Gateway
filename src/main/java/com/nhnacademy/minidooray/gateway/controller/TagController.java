package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("clienr/projects")
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
        
        return "redirect:/";
    }

}
