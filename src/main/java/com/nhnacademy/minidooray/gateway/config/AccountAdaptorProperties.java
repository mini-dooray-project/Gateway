package com.nhnacademy.minidooray.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.nhnacademy.minidooray.gateway")
public class AccountAdaptorProperties {

    String address;
}
