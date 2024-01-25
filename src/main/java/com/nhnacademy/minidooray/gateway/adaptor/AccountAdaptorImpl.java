package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.config.AccountAdaptorProperties;
import com.nhnacademy.minidooray.gateway.domain.Account;
import com.nhnacademy.minidooray.gateway.model.AccountRegisterRequest;
import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.model.LoginRequest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class AccountAdaptorImpl implements AccountAdaptor {
    private final AccountAdaptorProperties accountAdaptorProperties;

    private final RestTemplate restTemplate;

    public AccountAdaptorImpl(AccountAdaptorProperties accountAdaptorProperties, RestTemplate restTemplate) {
        this.accountAdaptorProperties = accountAdaptorProperties;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Account> getAccounts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        //responseEntity
        ResponseEntity<List<Account>> exchange = restTemplate.exchange(accountAdaptorProperties.getAddress() + "/accounts",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Account>>() {
                });
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public AccountResponse getAccount(String accountId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<AccountResponse> exchange = restTemplate.exchange(accountAdaptorProperties.getAddress() + "/accounts/{accountId}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<AccountResponse>() {
                }, accountId);
        return exchange.getBody();
    }

    @Override
    public Account createAccount(AccountRegisterRequest account) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        log.debug("address:", accountAdaptorProperties.getAddress());
        HttpEntity<AccountRegisterRequest> requestEntity = new HttpEntity<>(account, httpHeaders);

        ResponseEntity<Account> exchange = restTemplate.exchange(accountAdaptorProperties.getAddress() + "/api/accounts",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<Account>() {
                });
        return exchange.getBody();
    }

    @Override
    public void deleteAccount(String accountId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Account> exchange = restTemplate.exchange(accountAdaptorProperties.getAddress() + "/accounts/{accountId}",
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<Account>() {
                }, accountId);
    }

    @Override
    public Boolean matchLogin(LoginRequest loginRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<LoginRequest> requestEntity = new HttpEntity<>(loginRequest, httpHeaders);

        ResponseEntity<Boolean> exchange = restTemplate.exchange(accountAdaptorProperties.getAddress() + "/api/accounts/login",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        return exchange.getBody();
    }
}
