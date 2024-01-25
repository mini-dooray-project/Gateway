package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.minidooray.gateway.domain.Account;
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
    public List<Account> getAccounts() {
        return accountAdaptor.getAccounts();
    }

    @Override
    public Account getAccount(String accountId) {
        if (Objects.isNull(accountId)) {
            throw new NullPointerException();
        }
        return accountAdaptor.getAccount(accountId);
    }

    @Override
    public void createAccount(Account account) {
        if (Objects.isNull(account)) {
            throw new NullPointerException("create account null");
        }
        accountAdaptor.createAccount(account);

    }

    @Override
    public void deleteAccount(String accountId) {
        if (Objects.isNull(accountId) || accountId.isEmpty()) {
            throw new IllegalArgumentException();
        }
        accountAdaptor.deleteAccount(accountId);

    }
}
