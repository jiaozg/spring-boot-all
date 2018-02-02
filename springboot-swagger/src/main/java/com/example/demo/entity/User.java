package com.example.demo.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by jiaozhiguang on 2018/1/12.
 */
public class User {

    @NotEmpty(message = "用户名不能为空")
    private String name;
    @Max(value = 100)
    @Min(value = 18, message = "年龄必须大于18岁")
    private int age;
    private String password;


}
