package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.EmployerValidator;
import kodlamaio.hrms.business.validationRules.UserValidator;
import kodlamaio.hrms.core.adapters.abstracts.MailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validations.EmailValidator;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserDao userDao;
	private MailService mailService;
	private ActivationCodeService activationCodeService; 

	public EmployerManager(EmployerDao employerDao, MailService mailService,
			UserDao userDao, ActivationCodeService activationCodeService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.mailService = mailService;
		this.activationCodeService = activationCodeService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.listEmployer);
	}

	@Override
	public Result add(Employer employer) {
		
		if (!UserValidator.userIdMustBeGreaterThanZero(employer.getUserId())) {
			return new ErrorResult(Messages.userIdMustBeGreaterThanZero);
		}

		if (!EmployerValidator.companyNameIsRequired(employer.getCompanyName())) {
			return new ErrorResult(Messages.companyNameCannotBeEmpty);
		}

		if (!EmployerValidator.webSiteIsRequired(employer.getWebSite())) {
			return new ErrorResult(Messages.webAddressCannotBeEmpty);
		}

		if (!EmployerValidator.phoneNumberIsRequired(employer.getPhoneNumber())) {
			return new ErrorResult(Messages.phoneNumberCannotBeEmpty);
		}

		if (!UserValidator.emailIsRequired(employer.getEmail())) {
			return new ErrorResult(Messages.emailCannotBeEmpty);
		}
		
		if (!EmailValidator.isEmailValid(employer.getEmail())) {
			return new ErrorResult(Messages.emailPatternNotValid);
		}

		if (!UserValidator.passwordIsRequired(employer.getPassword())) {
			return new ErrorResult(Messages.passwordCannotBeEmpty);
		}

		if (!UserValidator.repasswordIsRequired(employer.getRepassword())) {
			return new ErrorResult(Messages.repasswordCannotBeEmpty);
		}

		if (!UserValidator.passwordAndRepasswordDoNotMatch(employer.getPassword(), employer.getRepassword())) {
			return new ErrorResult(Messages.passwordAndRepasswordDoNotMatch);
		}

		if (!UserValidator.passwordMinimumSixCharacter(employer.getPassword())) {
			return new ErrorResult(Messages.passwordMinimumSixCharacter);
		}

		if (!EmployerValidator.employerDomainCheck(employer)) {
			return new ErrorResult(Messages.domainVerificationIsNotValid);
		}
		
		if (this.userDao.getById(employer.getUserId()) == null) {
			return new ErrorResult(Messages.userDoesNotExist);
		}

		if (this.mailService.isValidEmail(employer)) {
			return new ErrorResult(Messages.emailAlreadyValid);
		}

		Employer employerResult = this.employerDao.getByEmail(employer.getEmail());
		if (employerResult != null) {
			return new ErrorResult(Messages.previouslyRegisteredEmailOrNationalIdentity);
		}

		this.mailService.isValidEmail(employer);
		Employee employee = new Employee();
		employee.setIsConfirmed(true);
		// activation code
		User savedUser = this.userDao.save(employer);
		this.activationCodeService.createActivationCode(savedUser);
		// activation code
		this.employerDao.save(employer);
		return new SuccessResult(employer.getEmail() + " adresine doğrulama kodu gönderildi");
	}

}
