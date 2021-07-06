package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.CandidateValidator;
import kodlamaio.hrms.business.validationRules.UserValidator;
import kodlamaio.hrms.core.adapters.abstracts.MailService;
import kodlamaio.hrms.core.adapters.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validations.EmailValidator;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserDao userDao;
	private MernisService mernisService;
	private MailService mailService;
	private ActivationCodeService activationCodeService; 

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserDao userDao, MernisService mernisService, 
			MailService mailService, ActivationCodeService activationCodeService) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.mernisService = mernisService;
		this.mailService = mailService;
		this.activationCodeService = activationCodeService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), Messages.listCandidate);
	}

	@Override
	public Result add(Candidate candidate) {
		
		if (!UserValidator.userIdMustBeGreaterThanZero(candidate.getUserId())) {
			return new ErrorResult(Messages.userIdMustBeGreaterThanZero);
		}
		
		if (!CandidateValidator.firstNameIsRequired(candidate.getFirstName())) {
			return new ErrorResult(Messages.firstNameCannotBeEmpty);
		}

		if (!CandidateValidator.lastNameIsRequired(candidate.getLastName())) {
			return new ErrorResult(Messages.lastNameCannotBeEmpty);
		}
		
		if (!CandidateValidator.nationalIdentityIsRequired(candidate.getNationalIdentity())) {
			return new ErrorResult(Messages.nationalIdentityCannotBeEmpty);
		}

		if (!CandidateValidator.birthDateIsRequired(candidate.getBirthDate())) {
			return new ErrorResult(Messages.birthDateCannotBeEmpty);
		}

		if (!UserValidator.emailIsRequired(candidate.getEmail())) {
			return new ErrorResult(Messages.emailCannotBeEmpty);
		}
		
		if (!EmailValidator.isEmailValid(candidate.getEmail())) {
			return new ErrorResult(Messages.emailPatternNotValid);
		}

		if (!UserValidator.passwordIsRequired(candidate.getPassword())) {
			return new ErrorResult(Messages.passwordCannotBeEmpty);
		}
		
		if (!UserValidator.repasswordIsRequired(candidate.getRepassword())) {
			return new ErrorResult(Messages.repasswordCannotBeEmpty);
		}
		
		if (!UserValidator.passwordMinimumSixCharacter(candidate.getPassword())) {
			return new ErrorResult(Messages.passwordMinimumSixCharacter);
		}
		
		if (!UserValidator.passwordAndRepasswordDoNotMatch(candidate.getPassword(), candidate.getRepassword())) {
			return new ErrorResult(Messages.passwordAndRepasswordDoNotMatch);
		}
		
		if (this.userDao.getById(candidate.getUserId()) == null) {
			return new ErrorResult(Messages.userDoesNotExist);
		}
		
		if (this.mailService.isValidEmail(candidate)) {
			return new ErrorResult(Messages.emailAlreadyValid);
		}
		
		if (!this.mernisService.isValidNationalIdentity(candidate)) {
			return new ErrorResult(Messages.mernisVerificationIsNotValid);
		}
		
		Candidate employeeValue = this.candidateDao.getByEmailOrNationalIdentity(candidate.getEmail(),
				candidate.getNationalIdentity());
		if (employeeValue != null) {
			return new ErrorResult(Messages.previouslyRegisteredEmailOrNationalIdentity);
		}
		
		this.mernisService.isValidNationalIdentity(candidate);
		this.mailService.isValidEmail(candidate);
		User savedUser = this.userDao.save(candidate);
		this.activationCodeService.createActivationCode(savedUser);
		this.candidateDao.save(candidate);
		return new SuccessResult(candidate.getEmail() + " adresine doğrulama kodu gönderildi");
	}

}
