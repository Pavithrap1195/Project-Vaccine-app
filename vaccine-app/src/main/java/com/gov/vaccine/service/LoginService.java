package com.gov.vaccine.service;

import java.util.HashMap;
import java.util.Map;

public interface LoginService {
	
	Map<String, String> map= new HashMap<String, String>();
	
	public boolean validateUserNameAndPassword(String userName,String password);
	
	public boolean verifyUsernameAndPassword(String userName,String userPassword);
	
//	public boolean loginAttempts(String userName);

}
