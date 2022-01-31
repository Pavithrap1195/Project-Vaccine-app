package com.gov.vaccine.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gov.vaccine.dto.SignUpDTO;
import com.gov.vaccine.service.SignUpService;

@Controller
@RequestMapping("/")
public class SignUpController {

	@Autowired
	private SignUpService signUpService;
	
	@Autowired
	private OTPController otpController;

	@RequestMapping(value = "/signUp.vaccine", method = RequestMethod.POST)
	public String onClickSaveSignUpDetails(@ModelAttribute SignUpDTO signUpDTO, Model model) {
		System.out.println("Invoked onClickSaveSignUpDetails()");
		if (this.signUpService.validateSignUpDTO(signUpDTO)) {
			boolean isSent = this.signUpService.sendUsernameAndPassword(signUpDTO.getUserName(), signUpDTO.getPassword(),otpController.getEmail());
			boolean isSaved = this.signUpService.saveSignUpDTO(signUpDTO);
			if (isSaved && isSent) {
				model.addAttribute("validateMessage", "Details saved successfully and mail has been sent...Thank you");
				return "Login";
			} else {
				model.addAttribute("validateMessage", "Details not saved try again");
				return "Sign-Up";
			}
		} else {
			Map<String, String> map = this.signUpService.map;
			model.addAttribute("validateUserName", map.get("USERNAME"));
			model.addAttribute("validatedMobileNumber", map.get("MOBILENUMBER"));
			model.addAttribute("validateGender", map.get("GENDER"));
			model.addAttribute("validateDOB", map.get("DOB"));
			model.addAttribute("validatePassword", map.get("PASSWORD"));
			model.addAttribute("validateConfirmPassword", map.get("CONFIRMPASSWORD"));
		}
		return "Sign-Up";

	}

}
