package com.gov.vaccine.service;

import java.util.HashMap;
import java.util.Map;

import com.gov.vaccine.dto.AddMemberDTO;

public interface AddMemberService {
	
	Map<String, String> map = new HashMap<String, String>();
	
	public boolean validateMemberDetails(AddMemberDTO addMemberDTO);
	
	public boolean saveMemberDetails(AddMemberDTO addMemberDTO);

	
	
}
