package com.example.demo.UserController;



import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Bean.NewPassWord;
import com.example.demo.UserService.UserService;
import com.example.demo.vo.User;

import jakarta.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/userLogin")
	public String login(String userName, String passWord, HttpSession session) {
		User user = userService.userLogin(userName, passWord);
		LocalDate currentDate = LocalDate.now();
		if (user.getEndTime().toLocalDate().compareTo(currentDate)<0) {
			session.setAttribute("user", user);
			return "redirect:/changepw";// 如果当前时间在用户有效期时间之后，则跳转到changepw界面
		} else {
			session.setAttribute("user", user);
			return "redirect:/shareaddressbook";// 如果密码没有过期，则直接跳转到addressshareaddressbook页面
		}
	}

	@RequestMapping("/changePassWord")
	public String updatePw(NewPassWord newPassWord, HttpSession session) {
		userService.updatePw(newPassWord);
		return "login";// 修改密码成功，跳转到登录界面
	}

}

