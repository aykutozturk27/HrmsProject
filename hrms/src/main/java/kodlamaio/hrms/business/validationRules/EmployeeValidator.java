package kodlamaio.hrms.business.validationRules;

import com.google.common.base.Strings;

public class EmployeeValidator {
	
	public static boolean firstNameIsRequired(String firstName) {
		if (!Strings.isNullOrEmpty(firstName)) {
			return true; 
		}
		return false;
	}
	
	public static boolean lastNameIsRequired(String lastName) {
		if (!Strings.isNullOrEmpty(lastName)) {
			return true; 
		}
		return false;
	}
	
//	public static boolean emailIsRequired(String email) {
//		if (!Strings.isNullOrEmpty(email)) {
//			return true; 
//		}
//		return false;
//	}
//	
//	public static boolean passwordIsRequired(String password) {
//		if (!Strings.isNullOrEmpty(password)) {
//			return true; 
//		}
//		return false;
//	}
//	
//	public static boolean repasswordIsRequired(String repassword) {
//		if (!Strings.isNullOrEmpty(repassword)) {
//			return true; 
//		}
//		return false;
//	}
	
}
