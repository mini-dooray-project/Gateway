package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.model.LoginRequest;
import com.nhnacademy.minidooray.gateway.service.AccountService;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
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
    public String doLogin(@ModelAttribute LoginRequest loginRequest,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          ModelMap modelMap) {
        try {
            if (accountService.matches(loginRequest)) {
                String uuid = UUID.randomUUID().toString();
                HttpSession session = request.getSession(true);

                AccountResponse accountResponse = accountService.getAccount(loginRequest.getId());
                session.setAttribute(uuid, accountResponse);

                Cookie cookie = new Cookie("login", uuid);
                response.addCookie(cookie);

                modelMap.addAttribute("loginId", session.getId());
                return "main";
            }

        } catch (Exception e) {
        }
        return "redirect:/client/login";
    }
}
