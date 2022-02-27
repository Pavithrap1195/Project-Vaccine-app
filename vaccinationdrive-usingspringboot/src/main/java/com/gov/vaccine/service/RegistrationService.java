package com.gov.vaccine.service;

import com.gov.vaccine.entity.UserOTPEntity;

public interface RegistrationService {

public boolean validateEmailID(String emailID);
	
	public int getOTP();
	
	public boolean sendOTP(String emailID,int otp);
	
	public UserOTPEntity saveUserOTP(String emailID,int otp);
	
	public boolean compareOTP(String emailID,int otp);
	
	public boolean updateUserOTPByEmailID(String emailID,int newOtp);

	
}
