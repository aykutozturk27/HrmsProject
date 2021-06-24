package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.MailService;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.mail.FakeEmailManager;

@Service
public class MailAdapter implements MailService {

	@Override
	public boolean isValidEmail(User user) {
		FakeEmailManager manager = new FakeEmailManager();
		if (manager.ValidateEmail(user)) {
			return true;
		}
		else {
			return false;
		}
	}

}
