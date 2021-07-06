package kodlamaio.hrms.business.validationRules;

import java.time.LocalDate;
import com.google.common.base.Strings;

public class CandidateValidator {
	
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
	
	public static boolean nationalIdentityIsRequired(String identityNumber) {
		if (!Strings.isNullOrEmpty(identityNumber)) {
			return true; 
		}
		return false;
	}
	
	public static boolean birthDateIsRequired(LocalDate birthDate) {
		if (birthDate != null) {
			return true; 
		}
		return false;
	}
}
