package com.gov.vaccine.util;

import java.util.Random;

import org.springframework.stereotype.Repository;

public class OTPGenerator {

	public static int generateOTP() {
		System.out.println("Invoked generateOTP()");
		Random random = new Random();
		int nextInt = random.nextInt(10000);

		return nextInt;
	}

}
