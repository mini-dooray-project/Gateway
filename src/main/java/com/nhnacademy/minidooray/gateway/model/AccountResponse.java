package com.nhnacademy.minidooray.gateway.model;


import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AccountResponse implements Serializable {
    private String id;
    private String password;
    private String name;
    private String email;
    private LocalDate createdDate;
    private LocalDate latestLoginDate;
    private String state;
}

