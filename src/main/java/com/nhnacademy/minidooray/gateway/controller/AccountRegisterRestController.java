package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.domain.Account;
import com.nhnacademy.minidooray.gateway.model.AccountRegisterRequest;
import com.nhnacademy.minidooray.gateway.service.AccountService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountRegisterRestController {
    private final AccountService accountClientService;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountClientService.getAccounts();
    }
    
//    @GetMapping("/accounts/{id}")
//    public AccountResponse getAccount(@PathVariable String id) {
//        return accountClientService.getAccount(id);
//    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody AccountRegisterRequest response) {
        return accountClientService.createAccount(response);
    }


}
