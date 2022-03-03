package com.gov.vaccine.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gov.vaccine.controller.SignUpController;
import com.gov.vaccine.dto.AddMemberDTO;
import com.gov.vaccine.service.AddMemberService;
import com.gov.vaccine.service.SignUpService;

@RestController
public class AddMemberRestController {

	@Autowired
	private AddMemberService addMemberService;

	@Autowired
	private SignUpService signUpService;

	@Autowired
	private SignUpController signUpController;

	@PostMapping(value = "/savemember/{userName}")
	public String addMember(@RequestBody AddMemberDTO addMemberDTO,@PathVariable(value="userName",required = false)String userName) {
		if (this.signUpService.memberCount(userName)) {
			if (this.addMemberService.saveMemberDetails(addMemberDTO)) {
				return "Member details saved successfully...Thank You!!";
			} else {
				return "Member details has not been saved...Try Again!!";
			}
		} else {
			return "You can add 6 members only.So Signup with another account";
		}
	}

}
