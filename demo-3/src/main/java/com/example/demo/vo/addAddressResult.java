package com.example.demo.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class addAddressResult {
	private String abName;
    private String group;
    private String projectName;
    private String registerName;
    private LocalDate createDate;
}
