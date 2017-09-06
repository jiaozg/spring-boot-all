package com.example.demo.storage;

/**
 * Created by jiaozhiguang on 2017/8/25.
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
