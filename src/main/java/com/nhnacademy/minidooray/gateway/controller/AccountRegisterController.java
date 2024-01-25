package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.model.AccountRegisterRequest;
import com.nhnacademy.minidooray.gateway.service.AccountService;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/client/accounts")
public class AccountRegisterController {
    private final AccountService accountService;

    public AccountRegisterController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/register")
    public String viewRegister() {

        return "account-register-form";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute AccountRegisterRequest request) {
        log.debug("value:{}", request);
        if (Objects.isNull(request)) {
            throw new NullPointerException("doRegister null");
        }
        accountService.createAccount(request);
        return "main";
    }
}
