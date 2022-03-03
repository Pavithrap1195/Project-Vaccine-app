package com.gov.vaccine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String onClickLogout(HttpServletRequest request) {
		System.out.println("Invoked onClickLogout()");
		HttpSession httpSession = request.getSession(false);
		if(httpSession!=null) {
			httpSession.removeAttribute("UserName");
			httpSession.invalidate();	
		}
		return "Login";
	}

	
}
