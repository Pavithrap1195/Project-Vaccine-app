package com.gov.vaccine.dao;

import com.gov.vaccine.entity.UserOTPEntity;

public interface UserOTPDAO {
	
	boolean saveUserOTP(UserOTPEntity userOTPEntity);
	
	int getUserOTPByEmailID(String emailID);
	
	 

}
