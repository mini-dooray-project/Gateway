package com.nhnacademy.minidooray.gateway.config;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Getter
@ConfigurationProperties(prefix = "com.nhnacademy.minidooray.gateway.account")
public class AccountAdaptorProperties {
    @NotNull
    String address;
}
