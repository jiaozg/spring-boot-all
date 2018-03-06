package com.example.demo.exception;

public class FormRepeatException extends RuntimeException {
 
    public FormRepeatException(String message){ super(message);}
 
    public FormRepeatException(String message, Throwable cause){ super(message, cause);}
}