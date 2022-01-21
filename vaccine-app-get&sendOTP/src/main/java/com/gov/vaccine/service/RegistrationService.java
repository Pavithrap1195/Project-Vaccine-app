package com.gov.vaccine.service;

public interface RegistrationService {
	
	public boolean validateEmailID(String emailID);
	
	public Number getOTP();
	
	public boolean sendOTP(String emailID,Number otp); 
	

}
