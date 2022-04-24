package com.mainstream.userapp.exception;

public class PhoneNumberAlreadyTakenException extends RuntimeException{
    private static  final long serialVersionUID = 1L;

    public PhoneNumberAlreadyTakenException(String message) {
        super(message);
    }
}
