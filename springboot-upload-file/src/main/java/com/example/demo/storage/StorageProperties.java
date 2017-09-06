package com.example.demo.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by jiaozhiguang on 2017/8/25.
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
