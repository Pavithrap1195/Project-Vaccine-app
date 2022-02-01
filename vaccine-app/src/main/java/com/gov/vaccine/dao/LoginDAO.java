package com.gov.vaccine.dao;

import com.gov.vaccine.entity.SignUpEntity;

public interface LoginDAO {

	public SignUpEntity getEntityByUsername(String userName);
	
	public int getLoginAttemptsByUsername(String userName);
	
	public boolean updateLoginAttemptsByUsername(String userName,int loginAttempts);

}
