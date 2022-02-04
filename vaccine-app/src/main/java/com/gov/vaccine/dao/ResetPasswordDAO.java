package com.gov.vaccine.dao;

public interface ResetPasswordDAO {
	
	public boolean updatePasswordByUsername(String password,String userName);

}
