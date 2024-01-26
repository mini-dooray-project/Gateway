package com.nhnacademy.minidooray.gateway.util;

import com.nhnacademy.minidooray.gateway.exception.CookieNotFoundException;
import javax.servlet.http.Cookie;

public class CookieUtil {
    public static Cookie getCookie(Cookie[] cookies, String cookieName) {
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie;
            }
        }
        throw new CookieNotFoundException("cookie not found");
    }
}
