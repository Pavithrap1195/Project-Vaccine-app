package com.gov.vaccine.util;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public class OTPGenerator {

	public Number generateOTP() {
		System.out.println("Invoked generateOTP()");
		Random random = new Random();
		int nextInt = random.nextInt(10000);

		return nextInt;
	}

}
