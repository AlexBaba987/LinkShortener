package com.ak.helper;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateRandomPassword {

	public static String pwd() {
		
		String password=RandomStringUtils.random (6, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789");
		return password;
	}
}
