package com.example.demo.entity;

import com.example.demo.enums.UserSexEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String passWord;
	private UserSexEnum userSex;
	private String nickName;
	private String phoneNo;

	public UserEntity() {
		super();
	}

	public UserEntity(String userName, String phoneNo) {
		super();
		this.userName = userName;
		this.phoneNo = phoneNo;
	}

	public UserEntity(String userName, String passWord, UserSexEnum userSex) {
		super();
		this.passWord = passWord;
		this.userName = userName;
		this.userSex = userSex;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "userName " + this.userName + ", pasword " + this.passWord + "sex " + userSex.name();
	}

}