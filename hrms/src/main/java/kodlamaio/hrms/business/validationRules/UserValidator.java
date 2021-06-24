package kodlamaio.hrms.business.validationRules;

import com.google.common.base.Strings;

public class UserValidator {
	
	public static boolean userIdMustBeGreaterThanZero(int userId) {
		if (userId > 0) {
			return true; 
		}
		return false;
	}

	public static boolean emailIsRequired(String email) {
		if (!Strings.isNullOrEmpty(email)) {
			return true; 
		}
		return false;
	}
	
	public static boolean passwordIsRequired(String password) {
		if (!Strings.isNullOrEmpty(password)) {
			return true; 
		}
		return false;
	}
	
	public static boolean repasswordIsRequired(String repassword) {
		if (!Strings.isNullOrEmpty(repassword)) {
			return true; 
		}
		return false;
	}
	
	public static boolean passwordAndRepasswordDoNotMatch(String password, String repassword) {
		if (password != repassword) {
			return true;
		}
		return false;
	}
	
	public static boolean passwordMinimumSixCharacter(String password) {
		if (!(password.length() < 6)) {
			return true;
		}
		return false;
	}
	
}
