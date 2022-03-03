package com.gov.vaccine.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gov.vaccine.entity.UserOTPEntity;
import com.gov.vaccine.service.RegistrationService;

@RestController
public class VerifyOTPRestController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private OTPRestController otpController;

	@GetMapping("/processOTP/{otp}")
	public String compareOTP(@PathVariable(value = "otp", required = false) int otp) {
		boolean compareOTP = this.registrationService.compareOTP(otpController.getEmail(), otp);
		if (compareOTP) {
			System.out.println("OTP verified successfully");
			return "OTP verified successfully";
		} else {
			System.out.println("OTP is not valid");
			return "OTP is not valid";
		}
	}

	int newOTP;

	@GetMapping("/resendOTP")
	public int resendOTP(@RequestParam(value = "emailID", required = false) String emailID) {
		newOTP = this.registrationService.getOTP();
		return newOTP;
	}

	@PutMapping("/updateOTP/{emailID}")
	public int updateOTP(@PathVariable(value="emailID",required = false) String emailID, @RequestBody UserOTPEntity userOTPEntity) {
		System.out.println(newOTP);
		System.out.println(emailID);
		System.out.println("otpController "+otpController.getEmail());
		this.registrationService.updateUserOTPByEmailID(emailID, newOTP);
		this.registrationService.sendOTP(emailID, newOTP);
		return newOTP;
	}

}
