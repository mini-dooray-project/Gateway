package com.nhnacademy.minidooray.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
    private String id;
    private String password;
}
