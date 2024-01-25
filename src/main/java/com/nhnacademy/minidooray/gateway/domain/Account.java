package com.nhnacademy.minidooray.gateway.domain;

import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;
    private String password;
    private String name;
    private String email;
    private LocalDate createdDate;
    private LocalDate latestLoginDate;
    private String state;
}
