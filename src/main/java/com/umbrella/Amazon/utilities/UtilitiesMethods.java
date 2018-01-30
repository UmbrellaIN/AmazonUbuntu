package com.umbrella.Amazon.utilities;

import org.apache.commons.net.util.Base64;
import org.apache.log4j.Logger;

import com.umbrella.Amazon.generics.LoggerHelper;

public class UtilitiesMethods {

	private static final Logger log = LoggerHelper.getLogger(UtilitiesMethods.class);

	// This method converts String p = "Rs. 1,200"; in well formatted int value
	// 1200
	public int convertStringtoInt(String p) {
		if (p.startsWith("R")) {
			String actualData = p.substring(4);
			String seconditer = actualData.replaceAll(",", "");
			System.out.println(seconditer);
			double p1 = Double.parseDouble(seconditer);
			int productPrice = (int) (p1);
			System.out.println("Value is " + productPrice);
			return productPrice;
		} else if (p.startsWith("-")) {
			System.out.println(" I am in Else Part");

			String actualData = p.substring(5);
			String seconditer = actualData.replaceAll(",", "");
			System.out.println(seconditer);
			double p1 = Double.parseDouble(seconditer);
			int productPrice = (int) (p1);
			System.out.println("Value is " + productPrice);
			return productPrice;
		}
		return 1;
	}

	// Base 64 is a class present in Apache commons Package and contains two
	// methods to enrypt and decrypt

	public static String encodePassword(String password) {
		log.info(" this method will decrpt the encrpyt the password");
		byte[] encryptedpassword = Base64.encodeBase64(password.getBytes());
		return new String(encryptedpassword);

	}

	public static String decodePassword(String encryptedpassword) {
		log.info(" this method will decrpt the encrpyt the password");
		byte[] password = Base64.decodeBase64(encryptedpassword);
		return new String(password);

	}

	public static void main(String[] args) {
		// String p = "-Rs. 1,200";
		// UtilitiesMethods utm = new UtilitiesMethods();
		// utm.convertStringtoInt(p);

		String pwd = "india1123";
		String encrptedpassword = encodePassword(pwd);
		System.out.println(" The Encrypted Password is " + new String(encrptedpassword));

		String decpassword = decodePassword(encrptedpassword);
		System.out.println(" The deccrypted Password is " + new String(decpassword));
	}

}
