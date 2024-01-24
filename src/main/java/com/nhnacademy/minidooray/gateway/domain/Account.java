package com.nhnacademy.minidooray.gateway.domain;

import java.time.LocalDateTime;
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
    private LocalDateTime createdDate;
    private LocalDateTime latestLoginDate;
    private String state;
}
