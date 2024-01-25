package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.domain.Account;
import com.nhnacademy.minidooray.gateway.model.AccountRegisterRequest;
import java.util.List;

public interface AccountAdaptor {
    List<Account> getAccounts();

    Account getAccount(String accountId);

    Account createAccount(AccountRegisterRequest account);


    void deleteAccount(String accountId);
}
