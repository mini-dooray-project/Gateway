package com.nhnacademy.minidooray.gateway.config;

import com.nhnacademy.minidooray.gateway.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration // 제가 세팅한 것만
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginCheckInterceptor loginCheckInterceptor = new LoginCheckInterceptor();
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/client/projects/**");
        registry.addInterceptor(new LocaleChangeInterceptor())
                .addPathPatterns("/client/projects/**")
                .excludePathPatterns("/client/projects");
    }
}
