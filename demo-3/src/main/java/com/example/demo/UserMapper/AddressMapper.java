package com.example.demo.UserMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Bean.AddressInfo;
import com.example.demo.vo.AddressResult;
import com.example.demo.vo.addAddressResult;
import com.example.demo.vo.registerResult;

@Mapper
public interface  AddressMapper {

	List<AddressResult> search(AddressInfo addressInfo);
	
	List<registerResult> getRegisterName();

	void add(addAddressResult addAddressResult);
}
