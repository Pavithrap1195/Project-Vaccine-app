package com.gov.vaccine.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gov.vaccine.dto.SignUpDTO;
import com.gov.vaccine.service.SignUpService;

@RestController
public class SignUpRestController {

	@Autowired
	private SignUpService signUpService;

	@Autowired
	private OTPRestController otpController;

	private String userName;

	public String getUserName() {
		return userName;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@PostMapping("/saveSignUp/{emailID}")
	public String saveSignUpDetails(@PathVariable(value="emailID",required = false)String emailID, @Valid @RequestBody SignUpDTO signUpDTO) {
		userName = signUpDTO.getUserName();
		password = signUpDTO.getPassword();
		boolean isSent = this.signUpService.sendUsernameAndPassword(signUpDTO.getUserName(), signUpDTO.getPassword(),
				emailID);
		boolean isSaved = this.signUpService.saveSignUpDTO(signUpDTO);
		
		if (isSaved && isSent) {
			return "Details saved successfully and mail has been sent...Thank you";
		} else {
			return "Details not saved try again";
		}
	}

}
