package kodlamaio.hrms.business.validationRules;

import java.time.LocalDate;

import com.google.common.base.Strings;

public class JobAdvertisementValidator {

	public static boolean jobDescriptionIsRequired(String jobDescription) {
		if (!Strings.isNullOrEmpty(jobDescription)) {
			return true;
		}
		return false;
	}

	public static boolean openPositionCountGreaterThanZero(int openPositionCount) {
		if (openPositionCount > 0) {
			return true;
		}
		return false;
	}

	public static boolean deadLineIsRequired(LocalDate deadLine) {
		if (!Strings.isNullOrEmpty(deadLine.toString())) {
			return true;
		}
		return false;
	}
}
