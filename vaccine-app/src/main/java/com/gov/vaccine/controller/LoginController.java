package com.gov.vaccine.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gov.vaccine.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginService loginService;

	/*private String userName;

	public String getUserName() {
		return userName;
	}
*/
	@RequestMapping(value = "/login.vaccine", method = RequestMethod.POST)
	public String onClickLogin(@RequestParam("userName") String userName, @RequestParam("password") String userPassword,
			Model model) {
		System.out.println("Invoked onClickLogin()");
		Map<String, String> map = this.loginService.map;
		if (this.loginService.loginAttempts(userName, userPassword)) {
			if (this.loginService.validateUserNameAndPassword(userName, userPassword)) {
				if (this.loginService.verifyUsernameAndPassword(userName, userPassword)) {
//					this.userName = userName;
					model.addAttribute("verifyMessage", "Successfully logged In... Thank You");
					return "Home";
				} else {
					model.addAttribute("Wrongpassword", map.get("WRONGPASSWORD"));
					return "Login";
				}
			} else {
				model.addAttribute("validateUserName", map.get("USERNAME"));
				model.addAttribute("validatePassword", map.get("PASSWORD"));
			}
		} else {
			model.addAttribute("LoginAttempts", map.get("ATTEMPTS"));
			return "Login";
		}
		return "Login";
	}
}