package com.nhnacademy.minidooray.gateway.model;


import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AccountResponse {
    private String id;
    private String password;
    private String name;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime latestLoginDate;
    private String state;
}

