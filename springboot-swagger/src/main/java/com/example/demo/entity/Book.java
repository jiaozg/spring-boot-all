package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jiaozhiguang on 2017/8/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private long id;
    private String name;
    private double price;

}
