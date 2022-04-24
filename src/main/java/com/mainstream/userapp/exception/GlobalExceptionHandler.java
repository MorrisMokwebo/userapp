package com.mainstream.userapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Global exception handler
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdentityNumberAlreadyTakenException.class)
    public ResponseEntity<?>identityNumberAlreadyTakenException(IdentityNumberAlreadyTakenException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PhoneNumberAlreadyTakenException.class)
    public ResponseEntity<?>phoneNumberAlreadyTakenException(PhoneNumberAlreadyTakenException ex,WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
        return  new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<?>clientNotFoundException(ClientNotFoundException ex,WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
        return  new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IDNumberNotValidException.class)
    public ResponseEntity<?>IDNumberNotValid(IDNumberNotValidException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
        return  new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }

}
