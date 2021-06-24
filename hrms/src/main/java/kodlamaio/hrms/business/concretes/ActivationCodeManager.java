package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.securities.PasswordGenerator;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService{

	private ActivationCodeDao activationCodeDao;
	String generatedCode = "";

	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}

	@Override
	public ActivationCode findByCode(String code) {
		return this.activationCodeDao.findByActivationCode(code);
	}

	@Override
	public DataResult<List<ActivationCode>> findByAllCode() {
		return new SuccessDataResult<List<ActivationCode>>(this.activationCodeDao.findAll(),
				Messages.listActivationCode);
	}

	@Override
	public String createActivationCode(User user) {
		
		generatedCode = PasswordGenerator.randomCodeGenarator(20); 
		
		ActivationCode activationCode = new ActivationCode();
		activationCode.setId(user.getId());
		activationCode.setActivationCode(generatedCode);
		activationCode.setIsActive(true);
		this.activationCodeDao.save(activationCode);
		return generatedCode;
	}

	@Override
	public Result activateUser(String activationCode) {
		ActivationCode activationCodeValue = this.activationCodeDao.findByActivationCode(activationCode);
		activationCodeValue.setVerified(true);
		this.activationCodeDao.save(activationCodeValue);
		return new SuccessResult(Messages.userActivationSuccessfully);
	}

}
