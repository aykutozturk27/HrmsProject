package kodlamaio.hrms.core.utilities.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	private static String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public static boolean isEmailValid(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
