package com.example.demo.exception;

/**
 * Created by jiaozhiguang on 2017/12/8.
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super();
    }

    public UserNotExistException(String message) {
        super(message);
    }

    public UserNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

}
