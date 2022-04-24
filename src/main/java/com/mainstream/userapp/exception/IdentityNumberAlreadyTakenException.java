package com.mainstream.userapp.exception;

public class IdentityNumberAlreadyTakenException extends RuntimeException{
    private static  final long serialVersionUID = 1L;

    public IdentityNumberAlreadyTakenException(String message) {
        super(message);
    }
}
