package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jiaozhiguang on 2017/8/21.
 */
@Data
@Entity
public class Account {
    @Id
    private int id ;
    private String name ;
    private double money;

}
