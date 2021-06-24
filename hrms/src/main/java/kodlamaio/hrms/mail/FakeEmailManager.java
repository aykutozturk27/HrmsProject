package kodlamaio.hrms.mail;

import kodlamaio.hrms.entities.abstracts.User;

public class FakeEmailManager {

	public boolean ValidateEmail(User user) {
		if (user.isMailVerify() == false) {
			user.setMailVerify(true);
			return true;			
		}
		else {
			return false;
		}
	}

}
