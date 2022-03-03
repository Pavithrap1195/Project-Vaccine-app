package com.gov.vaccine.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gov.vaccine.service.LoginService;

@RestController
public class LoginRestController {

	@Autowired
	private LoginService loginService;

	@GetMapping("/signin/{userName}/{password}")
	public String login(@PathVariable(value ="userName",required = false) String userName,@PathVariable(value="password",required = false) String userPassword) {
		if (this.loginService.verifyUsernameAndPassword(userName, userPassword)) {
			return "Successfully logged In... Thank You";
		} else if (this.loginService.loginAttempts(userName, userPassword)) {
			return "Username or password not matched";
		} else {
			return "Your attempts exceeds limit..Account is blocked";
		}
	}

}
