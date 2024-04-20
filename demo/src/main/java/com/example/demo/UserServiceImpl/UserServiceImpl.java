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

	/**
	 * ユーザー名とパスワードを検証します
	 * 
	 * @param userName ユーザー名
	 * @param passWord パスワード
	 */
	@Override
	public User userLogin(String userName, String passWord) {
		User user = userMapper.login(userName);// userNameからuserオブジェクトを返す
		
		return user;
	}

	/**
	 * 旧パスワードに基づいて新しいパスワードを更新します
	 * 
	 * @param newPassWord ユーザーのパスワード情報、古いパスワードと新しいパスワードが含まれます
	 */
	@Override
	public void updatePw(NewPassWord newPassWord) {
		// TODO Auto-generated method stub
		if (newPassWord.getPassWord() == null || newPassWord.getNewPassWord() == null || newPassWord.getPassWord() == ""
				|| newPassWord.getNewPassWord() == "") {
			throw new RuntimeException("パスワードを入力してください");
		}
		userMapper.update(newPassWord);
	}

}