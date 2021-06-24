package kodlamaio.hrms.business.validationRules;

import com.google.common.base.Strings;

import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerValidator {

	public static boolean employerDomainCheck(Employer employer) {

		String[] dizi = employer.getEmail().split("@");
		String email = dizi[1];

		String[] dizi2 = employer.getWebSite().split("www.");
		String domain = dizi2[1];

		if (email.equals(domain)) {
			System.out.println(email + domain);
			return true;

		} else {
			System.out.println(email + domain + "false");
			return false;
		}
	}
	
	public static boolean companyNameIsRequired(String companyName) {
		if (!Strings.isNullOrEmpty(companyName)) {
			return true; 
		}
		return false;
	}
	
	public static boolean webSiteIsRequired(String webSite) {
		if (!Strings.isNullOrEmpty(webSite)) {
			return true; 
		}
		return false;
	}
	
	public static boolean phoneNumberIsRequired(String phoneNumber) {
		if (!Strings.isNullOrEmpty(phoneNumber)) {
			return true; 
		}
		return false;
	}
}
