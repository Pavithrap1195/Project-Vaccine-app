package com.gov.vaccine.dao;

import com.gov.vaccine.entity.SignUpEntity;

public interface LoginDAO {

	public SignUpEntity getEntityByUsername(String userName);

}
