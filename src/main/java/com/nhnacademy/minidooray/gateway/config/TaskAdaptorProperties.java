package com.nhnacademy.minidooray.gateway.config;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.nhnacademy.minidooray.gateway.task")
public class TaskAdaptorProperties {
    @NotNull
    private String address;
}
