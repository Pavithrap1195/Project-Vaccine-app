package com.gov.vaccine.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gov.vaccine.controller.OTPController;
import com.gov.vaccine.entity.UserOTPEntity;
import com.gov.vaccine.service.ResetPasswordService;

@RestController
public class ResetPasswordRestController {

	@Autowired
	private ResetPasswordService resetPasswordService;

	@Autowired
	private OTPRestController otpRestController;
	


	@PostMapping("/resetpwd/{userName}/{password}/{confirmPassword}/{emailID}")
	public String resetPassword(@PathVariable(value = "userName", required = false) String userName,
			@PathVariable(value = "password", required = false) String newPassword,
			@PathVariable(value = "confirmPassword", required = false) String confirmPassword,@PathVariable(value = "emailID", required = false) String emailID) {
		boolean updated = this.resetPasswordService.updatePasswordByUserName(newPassword, userName);
		boolean isSent = this.resetPasswordService.sendUpdatedPassword(newPassword, emailID);
		if (updated && isSent) {
			return "Your new password has been saved and sent to mail successfully ";
		} else {
			System.out.println("Mail has not been saved and sent to user");
		}
		return "Mail has not been saved and sent to user";
	}

}
