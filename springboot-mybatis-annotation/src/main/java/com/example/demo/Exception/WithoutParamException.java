package com.example.demo.exception;

/**
 * Created by jiaozhiguang on 2017/12/7.
 */
public class WithoutParamException extends RuntimeException {

    public WithoutParamException() {
        super();
    }

    public WithoutParamException(String message) {
        super(message);
    }

    public WithoutParamException(String message, Throwable cause) {
        super(message, cause);
    }

}
