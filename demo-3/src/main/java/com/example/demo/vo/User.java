package com.example.demo.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class User {
	private String userName;
    private String passWord;
    private Date startTime;
    private Date endTime;

}