package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.domain.Account;
import com.nhnacademy.minidooray.gateway.model.AccountRegisterRequest;
import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.model.LoginRequest;
import java.util.List;

public interface AccountService {
    boolean matches(LoginRequest loginRequest);

    List<Account> getAccounts();

    AccountResponse getAccount(String accountId);

    Account createAccount(AccountRegisterRequest accountRegisterRequest);

    void deleteAccount(String accountId);

}
