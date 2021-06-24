package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.abstracts.User;

public interface MailService {

	boolean isValidEmail(User user);
	
}
