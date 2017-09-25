package com.example.demo.domain;//package com.bawei.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiaozhiguang on 2017/7/8.
 */
@Data
public class User implements Serializable {

    /**
     * 主键.
     */
    private String id;

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户名.
     */
    private String userName = "";

    /**
     * 手机号码.
     */
    private String mobileNo = "";

    /**
     * 邮箱.
     */
    private String email = "";

    /**
     * 密码.
     */
    private String password = "";

    /**
     * 用户类型.
     */
    private Integer userType = 0;

    /**
     * 注册时间.
     */
    private Date registerTime = new Date();

    /**
     * 所在区域.
     */
    private String region = "";

    /**
     * 是否有效 0 有效 1 无效.
     */
    private Integer validity = 0;

    /**
     * 头像.
     */
    private String headPortrait = "";

    public User() {}


    public User(String userName, String mobileNo) {
        this.userName = userName;
        this.mobileNo = mobileNo;
    }







}