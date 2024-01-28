package com.nhnacademy.minidooray.gateway.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.nhnacademy.minidooray.gateway.domain.Account;
import com.nhnacademy.minidooray.gateway.model.AccountRegisterRequest;
import com.nhnacademy.minidooray.gateway.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@WebMvcTest(AccountRegisterController.class)
class AccountRegisterControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountService accountService;

    @Test
    void viewRegister() throws Exception {
        mockMvc.perform(get("/client/accounts/register"))
                .andExpect(view().name("account-register-form"));
    }

    @Test
    void doRegister() throws Exception {
        AccountRegisterRequest accountRegisterRequest = new AccountRegisterRequest("user", "pw", "name", "email");

        when(accountService.createAccount(accountRegisterRequest)).thenReturn(new Account());

        mockMvc.perform(post("/client/accounts/register")
                        .param("id", accountRegisterRequest.getId())
                        .param("password", accountRegisterRequest.getPassword())
                        .param("name", accountRegisterRequest.getName())
                        .param("email", accountRegisterRequest.getEmail()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
        verify(accountService, times(1)).createAccount(accountRegisterRequest);
    }

    @Test
    void doRegister_thenThrowNullPointerException() throws Exception {
        mockMvc.perform(post("/client/accounts/register"))
                .andExpect(status().is5xxServerError())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NullPointerException));
    }
}