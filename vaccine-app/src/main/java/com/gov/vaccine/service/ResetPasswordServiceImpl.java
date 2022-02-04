package com.gov.vaccine.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gov.vaccine.controller.LoginController;
import com.gov.vaccine.controller.SignUpController;
import com.gov.vaccine.dao.ResetPasswordDAO;
import com.gov.vaccine.dto.SignUpDTO;
import com.gov.vaccine.entity.SignUpEntity;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

	@Autowired
	private ResetPasswordDAO resetPasswordDAO;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SignUpController signUpController;

	@Override
	public boolean validatePassword(String userName, String password, String confirmPassword) {
		System.out.println("Invoked validatePassword()");
		boolean validated = false;
		if (userName != null && !userName.isEmpty()) {
			if (userName.equals(signUpController.getUserName())) {
				validated = true;
			} else {
				validated = false;
				System.out.println("UserName is invalid");
				map.put("USERNAME", "UserName is invalid");
				return validated;
			}
		} else {
			validated = false;
			System.out.println("UserName is invalid");
			map.put("USERNAME", "UserName is invalid");
			return validated;
		}
		if (password != null && !password.isEmpty()) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid password");
			map.put("PASSWORD", "Invalid password");
			return validated;
		}
		if (confirmPassword != null && password.equals(confirmPassword)) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid confirm password");
			map.put("CONFIRMPASSWORD", "Invalid confirm password or password not matched");
			return validated;
		}
		return validated;
	}

	@Override
	public boolean updatePasswordByUserName(String newPassword, String userName) {
		System.out.println("Invoked updatePassword()");
		String encodedPassword = encoder.encode(newPassword);
		signUpController.setPassword(encodedPassword);
		boolean updatePasswordByUsername = this.resetPasswordDAO.updatePasswordByUsername(encodedPassword, userName);
		return updatePasswordByUsername;
	}

	@Override
	public boolean sendUpdatedPassword(String password, String emailID) {
		System.out.println("Invoked sendUpdatedPassword()");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(emailID);
		mailMessage.setSubject("Password has been successfully reset");
		mailMessage.setText("Your new password is " + password + " Kindly use this for future access");
		mailSender.send(mailMessage);
		return true;
	}

}
