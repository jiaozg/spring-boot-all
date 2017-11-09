package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by jiaozhiguang on 2017/11/8.
 */
@Data
@AllArgsConstructor
public class User implements Serializable {

    private Long id;
    private String email;
    private String userName;
}
