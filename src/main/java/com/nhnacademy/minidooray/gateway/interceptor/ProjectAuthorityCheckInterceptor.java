package com.nhnacademy.minidooray.gateway.interceptor;

import com.nhnacademy.minidooray.gateway.model.AccountResponse;
import com.nhnacademy.minidooray.gateway.service.ProjectMemberService;
import com.nhnacademy.minidooray.gateway.util.CookieUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ProjectAuthorityCheckInterceptor implements HandlerInterceptor {

    private final ProjectMemberService projectMemberService;

    public ProjectAuthorityCheckInterceptor(ProjectMemberService projectMemberService) {
        this.projectMemberService = projectMemberService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String uri = request.getRequestURI();
        Pattern pattern = Pattern.compile("/projects/(\\d+)");
        Matcher matcher = pattern.matcher(uri);
        String projectId = matcher.group(1);

        Cookie cookie = CookieUtil.getCookie(request.getCookies(), "login");
        HttpSession session = request.getSession(false);
        AccountResponse account = (AccountResponse) session.getAttribute(cookie.getValue());

        System.out.println("blocked!!!");
        return projectMemberService.authMember(account.getId(), Long.parseLong(projectId));
    }
}
