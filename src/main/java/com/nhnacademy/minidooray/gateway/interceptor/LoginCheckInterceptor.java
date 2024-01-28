package com.nhnacademy.minidooray.gateway.interceptor;

import com.nhnacademy.minidooray.gateway.util.CookieUtil;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getCookie(request.getCookies(), "login");
        if (session.getAttribute(cookie.getValue()) == null) {
            response.sendRedirect("/client/login");
            return false;
        }
        return true;
    }
}
