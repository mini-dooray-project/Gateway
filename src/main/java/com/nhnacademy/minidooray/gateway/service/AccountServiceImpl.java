package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.minidooray.gateway.domain.Account;
import com.nhnacademy.minidooray.gateway.model.AccountRegisterRequest;
import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.model.LoginRequest;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountAdaptor accountAdaptor;

    public AccountServiceImpl(AccountAdaptor accountAdaptor) {
        this.accountAdaptor = accountAdaptor;
    }

    @Override
    public boolean matches(LoginRequest loginRequest) {
        if (Objects.isNull(loginRequest)) {
            throw new NullPointerException("matches null");
        }
        return accountAdaptor.matchLogin(loginRequest);
    }

    @Override
    public List<Account> getAccounts() {
        return accountAdaptor.getAccounts();
    }

    @Override
    public AccountResponse getAccount(String accountId) {
        if (Objects.isNull(accountId)) {
            throw new NullPointerException();
        }
        return accountAdaptor.getAccount(accountId);
    }

    @Override
    public Account createAccount(AccountRegisterRequest accountRegisterRequest) {
        if (Objects.isNull(accountRegisterRequest)) {
            throw new NullPointerException("create account null");
        }
        return accountAdaptor.createAccount(accountRegisterRequest);
    }

    @Override
    public void deleteAccount(String accountId) {
        if (Objects.isNull(accountId) || accountId.isEmpty()) {
            throw new IllegalArgumentException();
        }
        accountAdaptor.deleteAccount(accountId);

    }
}
