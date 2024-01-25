package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.domain.Account;
import java.util.List;

public interface AccountAdaptor {
    List<Account> getAccounts();

    Account getAccount(String accountId);

    Account createAccount(Account account);

    Account deleteAccount(String accountId);
}
