package com.example.demo.UserService;

import org.springframework.stereotype.Service;

import com.example.demo.Bean.NewPassWord;
import com.example.demo.vo.User;

@Service
public interface UserService {
	User userLogin(String userName, String passWord);;
	void updatePw(NewPassWord newPassWord);


}
