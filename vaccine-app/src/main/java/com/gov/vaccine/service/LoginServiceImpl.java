package com.gov.vaccine.service;

import java.net.PasswordAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gov.vaccine.dao.LoginDAO;
import com.gov.vaccine.entity.SignUpEntity;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public boolean validateUserNameAndPassword(String userName, String password) {
		System.out.println("Invoked validateUserNameAndPassword()");
		boolean validated = false;
		if (userName != null && !userName.isEmpty()) {
			validated = true;
		} else {
			validated = false;
			System.out.println("UserName is invalid");
			map.put("USERNAME", "UserName is invalid");
			return validated;
		}
		if (!password.isEmpty() && password != null) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Password is invalid");
			map.put("PASSWORD", "Password is invalid");
			return validated;
		}
		return validated;
	}

	@Override
	public boolean verifyUsernameAndPassword(String userName, String userPassword) {
		System.out.println("Invoked verifyUsernameAndPassword()");
		SignUpEntity entity = this.loginDAO.getEntityByUsername(userName);
		boolean isMatched = encoder.matches(userPassword, entity.getPassword());
		if (isMatched) {
			if (userName.equals(entity.getUserName()) && userPassword.equals(entity.getPassword())) {
				return true;
			} else {
				System.out.println("Username not matched");
			}
		} else {
			System.out.println("Password not matched");
			int attempts = this.loginDAO.getLoginAttemptsByUsername(userName);
			attempts++;
			if (attempts >= 3) {
				System.out.println("Your attempts exceeds the limit");
				map.put("ATTEMPTS", "Your attempts exceeds limit..Account is blocked");
				return false;
			} else {
				System.out.println("Your password is wrong try again");
				map.put("WRONGPASSWORD", "Your password is wrong try again");
			}
			boolean updated = this.loginDAO.updateLoginAttemptsByUsername(userName, attempts);
			return false;
		}
		return false;
	}

	/*
	 * @Override public boolean loginAttempts(String userName) {
	 * System.out.println("Invoked ");
	 * 
	 * return false; }
	 */

}
