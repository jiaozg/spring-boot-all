package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jiaozhiguang on 2017/8/21.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {

    private String name;
    private String content;

    public Chapter(String name) {
        this.name = name;
    }
}
