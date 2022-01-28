package com.gov.vaccine.service;

public interface RegistrationService {
	
	public boolean validateEmailID(String emailID);
	
	public int getOTP();
	
	public boolean sendOTP(String emailID,int otp);
	
	public boolean saveUserOTP(String emailID,int otp);
	
	public boolean compareOTP(String emailID,int otp);
	
	public boolean updateUserOTPByEmailID(String emailID,int newOtp);
	
//	public boolean validateOTP(int otp);
	

}
