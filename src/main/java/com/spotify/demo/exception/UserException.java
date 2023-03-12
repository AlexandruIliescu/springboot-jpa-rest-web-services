package com.spotify.demo.exception;

public class UserException extends CustomApplicationException {

    public UserException(String message, int statusCode) {
        super(message, statusCode);
    }

    public UserException(String message, Throwable throwable, int statusCode) {
        super(message, throwable, statusCode);
    }

    public UserException() {
    }
}