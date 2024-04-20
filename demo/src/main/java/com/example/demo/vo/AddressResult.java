package com.example.demo.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AddressResult {
	private String abName;
	private String classGroup;
	private String projectName;
	private String registerName;
	private LocalDate creatDate;
	private int id;
}
