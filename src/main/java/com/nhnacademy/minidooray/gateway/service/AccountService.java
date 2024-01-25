package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.domain.Account;
import com.nhnacademy.minidooray.gateway.model.AccountRegisterRequest;
import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account getAccount(String accountId);

    Account createAccount(AccountRegisterRequest accountRegisterRequest);

    void deleteAccount(String accountId);
}
