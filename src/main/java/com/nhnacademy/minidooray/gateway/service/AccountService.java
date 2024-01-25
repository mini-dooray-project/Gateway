package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.domain.Account;
import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account getAccount(String accountId);

    void createAccount(Account account);

    void deleteAccount(String accountId);
}
