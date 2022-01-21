package com.gov.vaccine.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gov.vaccine.util.OTPGenerator;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	public OTPGenerator otpGenerator;

	@Autowired
	public JavaMailSender mailSender;

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
	public Number getOTP() {
		System.out.println("Invoked getOTP()");
		Number generateOTP = null;
		try {
			generateOTP = this.otpGenerator.generateOTP();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return generateOTP;
	}

	@Override
	public boolean sendOTP(String emailID, Number otp) {
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

}
