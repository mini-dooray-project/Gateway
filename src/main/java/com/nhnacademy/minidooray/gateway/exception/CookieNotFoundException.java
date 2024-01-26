package com.nhnacademy.minidooray.gateway.exception;

public class CookieNotFoundException extends RuntimeException {
    public CookieNotFoundException() {
    }

    public CookieNotFoundException(String message) {
        super(message);
    }
}
