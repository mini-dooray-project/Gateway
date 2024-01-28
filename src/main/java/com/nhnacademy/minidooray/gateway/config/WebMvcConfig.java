package com.nhnacademy.minidooray.gateway.config;

import com.nhnacademy.minidooray.gateway.interceptor.LoginCheckInterceptor;
import com.nhnacademy.minidooray.gateway.interceptor.ProjectAuthorityCheckInterceptor;
import com.nhnacademy.minidooray.gateway.service.ProjectMemberService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 제가 세팅한 것만
public class WebMvcConfig implements WebMvcConfigurer {
    private final ProjectMemberService projectMemberService;

    public WebMvcConfig(ProjectMemberService projectMemberService) {
        this.projectMemberService = projectMemberService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginCheckInterceptor loginCheckInterceptor = new LoginCheckInterceptor();
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/client/projects/**");
        registry.addInterceptor(new ProjectAuthorityCheckInterceptor(projectMemberService))
                .addPathPatterns("/client/projects/**")
                .excludePathPatterns("/client/projects");
    }
}
