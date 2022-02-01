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

	@RequestMapping(value = "/login.vaccine", method = RequestMethod.POST)
	public String onClickLogin(@RequestParam("userName") String userName, @RequestParam("password") String userPassword,
			Model model) {
		System.out.println("Invoked onClickLogin()");
		if (this.loginService.validateUserNameAndPassword(userName, userPassword)) {
			if (this.loginService.verifyUsernameAndPassword(userName, userPassword)) {
				model.addAttribute("verifyMessage", "Successfully logged In... Thank You");
				return "Home";
			} else {
				Map<String, String> map = this.loginService.map;
				model.addAttribute("LoginAttempts", map.get("ATTEMPTS"));
				model.addAttribute("Wrongpassword", map.get("WRONGPASSWORD"));
				return "Login";
			}
		} else {
			Map<String, String> map = this.loginService.map;
			model.addAttribute("validateUserName", map.get("USERNAME"));
			model.addAttribute("validatePassword", map.get("PASSWORD"));
		}
		return "Login";
	}

}
