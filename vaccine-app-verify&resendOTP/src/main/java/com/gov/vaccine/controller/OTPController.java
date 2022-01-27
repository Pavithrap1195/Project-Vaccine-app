package com.gov.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gov.vaccine.entity.UserOTPEntity;
import com.gov.vaccine.service.RegistrationService;

@Controller
@RequestMapping("/")
public class OTPController {

	@Autowired
	private RegistrationService registrationService;

	private String email;

	public String getEmail() {
		return email;
	}

	@RequestMapping(value = "/getOTP.vaccine", method = RequestMethod.POST)
	public String onClickProcessOTP(@RequestParam("emailID") String emailID, Model model) {
		System.out.println("Invoked onClickProcessOTP()");
		if (this.registrationService.validateEmailID(emailID)) {
			int otp = this.registrationService.getOTP();
			System.out.println("Your otp is : " + otp);
			boolean isSaved = this.registrationService.saveUserOTP(emailID, otp);
			this.email = emailID;
			boolean isSent = this.registrationService.sendOTP(emailID, otp);
			if (isSent && isSaved) {
				System.out.println("Mail has been saved and sent to user");
				model.addAttribute("SendingMessage", "OTP has been sent to your EmailID");
				return "VerifyOTP";
			} else {
				System.out.println("Mail has not been saved and sent to user");
				model.addAttribute("SendingMessage", "Mail has not been sent ");
			}
		} else {
			model.addAttribute("ValidationEmailID", "EmailID cannot be empty");
			return "VaccineRegistration";
		}

		return "VerifyOTP";
	}

	@RequestMapping(value = "/processOTP.vaccine", method = RequestMethod.POST)
	public String onClickVerifyAndProcess(@RequestParam("otp") int otp, Model model) {
		System.out.println("Invoked onClickVerifyAndProcess()");
		boolean compareOTP = this.registrationService.compareOTP(this.getEmail(), otp);
		if (compareOTP) {
			System.out.println("OTP verified successfully");
			return "Sign-Up";
		} else {
			model.addAttribute("ProcessMessage", "Your OTP is not valid");
			System.out.println("OTP is not valid");
			return "VaccineRegistration";

		}
	}

	@RequestMapping("/resendOTP.vaccine")
	public String onClickResendOTP(Model model) {
		System.out.println("Invoked onClickResendOTP()");
		int newOTP = this.registrationService.getOTP();
		boolean saveUserOTP = this.registrationService.saveUserOTP(this.getEmail(), newOTP);
		boolean isSent = this.registrationService.sendOTP(this.getEmail(), newOTP);
		if (saveUserOTP && isSent) {
			model.addAttribute("ResendingOTP", "OTP is resended to your mail");
			return "VerifyOTP";
		} else {
			model.addAttribute("ResendingOTP", "OTP is not sent..Try again!!");
			return "VerifyOTP";
		}
	}

}
