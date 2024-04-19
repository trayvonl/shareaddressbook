package com.example.demo.UserMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Bean.NewPassWord;
import com.example.demo.vo.User;
import com.example.demo.vo.registerResult;

@Mapper
public interface UserMapper {
	User login(String userName);

	List<registerResult> getRegisterName();

	void update(NewPassWord newPassWord);

}
