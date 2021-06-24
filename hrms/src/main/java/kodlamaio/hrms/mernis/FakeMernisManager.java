package kodlamaio.hrms.mernis;

import java.util.regex.Pattern;

public class FakeMernisManager {

	public boolean ValidateCandidate(String nationalIdentity, String firstName, String lastName, int yearOfBirth) {
		String regex = "^[0-9]+$";

		if (nationalIdentity.length() != 11) {
			return false;
		}
		
		Pattern pattern = Pattern.compile(regex);
		if(pattern.matcher(nationalIdentity).find()) {
			return true;
		}
		else {
			return false;
		}
	}

}
