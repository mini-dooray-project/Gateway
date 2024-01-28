package com.nhnacademy.minidooray.gateway.controller;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.nhnacademy.minidooray.gateway.service.AccountService;
import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountService accountService;


    @Test
    void viewMain() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("loginId", "test");
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);

        mockMvc.perform(get("/")
                        .session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("main"))
                .andExpect(model().attribute("loginId", session.getId()));
    }

    @Test
    void viewMain_withNoSession() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(view().name("main"))
                .andExpect(model().attributeDoesNotExist("loginId"));
    }
}