package com.mainstream.userapp.exception;

public class IDNumberNotValidException extends RuntimeException {
    private static  final long serialVersionUID = 1L;

    public IDNumberNotValidException(String message) {
        super(message);
    }
}
