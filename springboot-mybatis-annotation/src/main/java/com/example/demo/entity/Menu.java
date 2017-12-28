package com.example.demo.entity;


import lombok.Data;

@Data
public class Menu {
    private Integer id;

    private String code;

    private Integer parentid;

    private String name;

    private String icon;

    private String url;

    private Integer num;

    private Integer levels;

    private String tips;

}