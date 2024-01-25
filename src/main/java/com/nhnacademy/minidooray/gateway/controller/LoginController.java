package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.service.AccountService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class LoginController {
    private final AccountService accountService;

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/login")
    public String viewLoginForm() {
        return "login-form";
    }

    @PostMapping("/login")
    public String doLogin(HttpServletRequest request) {
        HttpSession session = request.getSession(true);


        return "main";
    }
}
