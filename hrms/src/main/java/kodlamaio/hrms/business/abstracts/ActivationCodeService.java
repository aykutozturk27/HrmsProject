package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {

	ActivationCode findByCode(String code);
	DataResult<List<ActivationCode>> findByAllCode();
	String createActivationCode(User user);
	Result activateUser(String activationCode);
	
}
