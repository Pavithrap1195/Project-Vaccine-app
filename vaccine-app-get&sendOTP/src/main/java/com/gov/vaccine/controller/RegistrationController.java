package com.gov.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gov.vaccine.service.RegistrationService;

@Controller
@RequestMapping("/")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping("/processOTP.vaccine")
	public String onClickProcessOTP(@RequestParam("emailID") String emailID, Model model) {
		System.out.println("Invoked onClickProcessOTP()");
		if (this.registrationService.validateEmailID(emailID)) {
			Number otp = this.registrationService.getOTP();
			boolean isSent = this.registrationService.sendOTP(emailID, otp);
			if (isSent) {
				model.addAttribute("SendingMessage", "OTP has been sent to your EmailID");
			return "VerifyOTP";
			} else {
				model.addAttribute("SendingMessage", "Mail has not been sent ");
			}
		} else {
			model.addAttribute("ValidationEmailID", "Not a valid EmailID");
		}

		return "VaccineRegistration";

	}

}
