package com.gov.vaccine.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gov.vaccine.entity.UserOTPEntity;
import com.gov.vaccine.service.RegistrationService;

@RestController
public class OTPRestController {

	@Autowired
	private RegistrationService registrationService;

	private String email;

	public String getEmail() {
		return email;
	}

	Integer otp;

	@GetMapping("/getOTP")
	public int onClickGetOTP(@RequestParam(value = "emailID", required = false) String emailID) {
		otp = this.registrationService.getOTP();
		return otp;
	}

	@PostMapping("/saveOTP")
	public UserOTPEntity onClickSaveOTP(@RequestBody UserOTPEntity userOTPEntity) {
		email=userOTPEntity.getEmailID();
		otp =userOTPEntity.getOtp();
		UserOTPEntity saveUserOTP = this.registrationService.saveUserOTP(email, otp);
		this.registrationService.sendOTP(email, otp);
		email=getEmail();
		System.out.println("EmailID "+email);
		System.out.println("GetEmail "+getEmail());
		
		return saveUserOTP;
	}

}
