package com.nhnacademy.minidooray.gateway.exception;

public class SessionNotFoundException extends RuntimeException {

    public SessionNotFoundException() {
    }

    public SessionNotFoundException(String message) {
        super(message);
    }

}
