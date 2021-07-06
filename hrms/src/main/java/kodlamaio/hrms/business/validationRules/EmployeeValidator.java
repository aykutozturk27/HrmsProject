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
	
}
