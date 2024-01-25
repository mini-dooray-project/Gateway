package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.domain.Account;
import com.nhnacademy.minidooray.gateway.model.AccountRegisterRequest;
import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.model.LoginRequest;
import java.util.List;

public interface AccountAdaptor {
    List<Account> getAccounts();

    AccountResponse getAccount(String accountId);

    Account createAccount(AccountRegisterRequest account);

    void deleteAccount(String accountId);

    Boolean matchLogin(LoginRequest loginRequest);
}
