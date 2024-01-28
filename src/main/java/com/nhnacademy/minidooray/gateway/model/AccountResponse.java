package com.nhnacademy.minidooray.gateway.model;


import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AccountResponse implements AccountDto {
    private String id;
    private String password;
    private String name;
    private String email;
    private LocalDate latestLoginDate;
    private LocalDate createdDate;
    private String accountState;
}

