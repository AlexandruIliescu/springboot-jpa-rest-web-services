package com.spotify.demo.exception;

public class CustomApplicationException extends RuntimeException {

    private int statusCode;

    public int getStatusCode() {
        return statusCode;
    }

    protected CustomApplicationException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    protected CustomApplicationException(String message, Throwable throwable, int statusCode) {
        super(message, throwable);
        this.statusCode = statusCode;
    }

    protected CustomApplicationException() {
    }
}