package com.nhnacademy.minidooray.gateway.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AccountRegisterRequest {
    private String id;
    private String password;
    private String name;
    private String email;
}

