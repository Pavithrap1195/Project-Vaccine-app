package com.gov.vaccine.service;

import java.util.HashMap;
import java.util.Map;

import com.gov.vaccine.dto.SignUpDTO;

public interface SignUpService {
	
	Map<String, String> map= new HashMap<String,String>();
	
	boolean validateSignUpDTO(SignUpDTO signUpDTO);
	
	boolean saveSignUpDTO(SignUpDTO signUpDTO);
	
	public boolean sendUsernameAndPassword(String userName,String password,String emailID);

}
