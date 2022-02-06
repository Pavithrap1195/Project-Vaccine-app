package com.gov.vaccine.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gov.vaccine.dto.AddMemberDTO;
import com.gov.vaccine.service.AddMemberService;

@Controller
@RequestMapping("/")
public class AddMemberController {

	@Autowired
	private AddMemberService addMemberService;

	@GetMapping("/addMember.vaccine")
	public String getAddMemberpage() {
		return "Add-Member";
	}
	
	@PostMapping(value="/addMember.vaccine")
	public String onClickAddMember(@ModelAttribute AddMemberDTO addMemberDTO, Model model) {
		System.out.println("Invoked onClickAddMember()");
		if (this.addMemberService.validateMemberDetails(addMemberDTO)) {
			this.addMemberService.saveMemberDetails(addMemberDTO);
			model.addAttribute("savedMsg", "Member details saved successfully...Thank You!!");
			return "Home";
		} else {
			Map<String, String> map = this.addMemberService.map;
			model.addAttribute("validateName", map.get("NAME"));
			model.addAttribute("validateGender", map.get("GENDER"));
			model.addAttribute("validateDob", map.get("DOB"));
			model.addAttribute("validateId", map.get("ID"));
			model.addAttribute("validateIdNumber", map.get("IDNUMBER"));
			model.addAttribute("validateType", map.get("TYPE"));
			model.addAttribute("validateDoses", map.get("DOSES"));
		}

		return "Add-Member";
	}

}
