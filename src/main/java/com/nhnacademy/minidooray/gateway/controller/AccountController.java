package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.service.AccountService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String viewMain(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            log.info("value:{}", model.getAttribute("loginId"));
        }
        return "main";
    }

    @PostMapping
    public ModelAndView postMain(HttpServletRequest request, ModelAndView modelAndView) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new NullPointerException();
        }
        log.info("value:{}", modelAndView.getModel().get("loginId"));

        modelAndView.setViewName("main");
        return modelAndView;
    }

}