package com.example.demo.UserController;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	// ユーザーログイン機能
	@RequestMapping("/userLogin")
	public String login(String userName, String passWord, HttpSession session, Model model) {
		User user = userService.userLogin(userName, passWord);
		LocalDate currentDate = LocalDate.now();
		session.setAttribute("user", user);
		try {
			if (userName == null || passWord == null || userName == "" || passWord == "") {
				throw new RuntimeException("ユーザー名とパスワードを入力してください");
			}

			if (user == null) {
				throw new RuntimeException("ユーザー名が間違っています");
			}

			if (!user.getPassWord().equals(passWord)) {
				throw new RuntimeException("パスワードが間違っています");
			}

			if (user.getEndTime().toLocalDate().compareTo(currentDate) < 0) {

				return "redirect:/changepw";// 現在の日付がユーザーの有効期限を過ぎている場合、changepwページにリダイレクト
			} else {
				return "redirect:/shareaddressbook";// パスワードがまだ期限切れでない場合、shareaddressbookページにリダイレクト
			}
		} catch (RuntimeException e) {
			model.addAttribute("error", e.getMessage());
			return "login";
		}
	}

	// ユーザーのパスワードを変更する機能
	@RequestMapping("/changePassWord")
	public String updatePw(NewPassWord newPassWord, HttpSession session) {
		System.out.println(newPassWord);
		userService.updatePw(newPassWord);
		return "login";// パスワードの変更に成功した場合、ログインページにリダイレクト
	}
}
