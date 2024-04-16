package com.example.demo.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Bean.NewPassWord;
import com.example.demo.UserMapper.UserMapper;
import com.example.demo.UserService.UserService;
import com.example.demo.vo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	 public User userLogin(String userName, String passWord) {
	        if (userName == null || passWord == null || userName == "" || passWord == "") {
	        	throw new RuntimeException("请输入用户名和密码");
	        }
	        User user = userMapper.login(userName);//根据userName返回user对象
	        if (user == null) {
	            throw new RuntimeException("用户名错误");
	        }

	        if (!user.getPassWord().equals(passWord)) {
	            throw new RuntimeException("密码错误");
	        }

	        return user;
	    }
	@Override
	public void updatePw(NewPassWord newPassWord) {
		// TODO Auto-generated method stub
		if (newPassWord.getNewPassWord().equals(newPassWord.getReNewPassWord())) {
			newPassWord.setNewPassWord(newPassWord.getNewPassWord());// 如果用户输入的新密码和旧密码一样则更改密码
            userMapper.update(newPassWord);
		}else {
			 throw new RuntimeException("两次输入的密码不一致");//否则抛异常
		}
	}

}
