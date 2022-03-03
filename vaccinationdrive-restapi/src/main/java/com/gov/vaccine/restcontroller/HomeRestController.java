package com.gov.vaccine.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gov.vaccine.entity.AddMemberEntity;
import com.gov.vaccine.service.AddMemberService;

@RestController
public class HomeRestController {

	@Autowired
	private AddMemberService addMemberService;

	@GetMapping("/getmembersList/{userName}")
	public List<AddMemberEntity> getMembersList(@PathVariable(value = "userName", required = false) String userName) {
		List<AddMemberEntity> allMemberDetails = this.addMemberService.getAllMemberDetails();
		return allMemberDetails;
	}

}
