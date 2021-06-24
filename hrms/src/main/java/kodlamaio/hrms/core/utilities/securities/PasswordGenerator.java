package kodlamaio.hrms.core.utilities.securities;

import java.security.SecureRandom;

public abstract class PasswordGenerator {

	private static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static SecureRandom random = new SecureRandom();

	public static String randomCodeGenarator(int length) {
		StringBuilder randomValueConstructor = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			randomValueConstructor.append(chars.charAt(random.nextInt(chars.length())));
		}
		return randomValueConstructor.toString();
	}
	
}
