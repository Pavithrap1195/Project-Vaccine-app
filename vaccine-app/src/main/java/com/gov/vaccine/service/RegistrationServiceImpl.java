package com.gov.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gov.vaccine.dao.UserOTPDAO;
import com.gov.vaccine.entity.UserOTPEntity;
import com.gov.vaccine.util.OTPGenerator;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	public JavaMailSender mailSender;

	@Autowired
	public UserOTPDAO userOTPDAO;

	@Override
	public boolean validateEmailID(String emailID) {
		System.out.println("Invoked validateEmailID()");
		boolean validated = false;
		try {
			if (emailID != null && !emailID.isEmpty()) {
				validated = true;
			} else {
				validated = false;
				System.out.println("EmailID should not be empty");
				return validated;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return validated;
	}

	@Override
	public int getOTP() {
		System.out.println("Invoked getOTP()");
		return OTPGenerator.generateOTP();
	}

	@Override
	public boolean sendOTP(String emailID, int otp) {
		System.out.println("Invoked sendOTP()");
		boolean isSent = false;
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(emailID);
			mailMessage.setSubject("Regarding OTP for Vaccination");
			mailMessage.setText(otp + " is your one time password to register for vaccination");
			mailSender.send(mailMessage);
			isSent = true;
			return isSent;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isSent;
	}

	@Override
	public boolean saveUserOTP(String emailID, int otp) {
		System.out.println("Invoked saveUserOTP() in ServiceImpl");
		UserOTPEntity userOTPEntity = new UserOTPEntity();
		userOTPEntity.setEmailID(emailID);
		userOTPEntity.setOtp(otp);
		boolean saveUserOTP = this.userOTPDAO.saveUserOTP(userOTPEntity);
		return saveUserOTP;
	}

	/*
	 * @Override public boolean validateOTP(int otp) {
	 * System.out.println("Invoked validateOTP()"); if (otp > 0) { return true; }
	 * else { System.out.println("Enter valid OTP"); return false; } }
	 */
	@Override
	public boolean compareOTP(String emailID, int otp) {
		System.out.println("Invoked compareOTP()");
		int userOTP = this.userOTPDAO.getUserOTPByEmailID(emailID);
		if (userOTP == otp) {
			System.out.println("UserOTP matched with otp");
			return true;
		} else {
			System.out.println("Invalid OTP....Try again...");
			return false;
		}
	}

	@Override
	public boolean updateUserOTPByEmailID(String emailID, int newOtp) {
		System.out.println("Invoked updateUserOTPByEmailID() ");
		boolean updateOtpByEmailID = this.userOTPDAO.updateOtpByEmailID(emailID, newOtp);
		return true;
	}

}
