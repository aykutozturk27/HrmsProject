package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.JobAdvertisementValidator;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerDao employerDao;
	private JobPositionDao jobPositionDao;
	private CityDao cityDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerDao employerDao,
			JobPositionDao jobPositionDao, CityDao cityDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao = employerDao;
		this.jobPositionDao = jobPositionDao;
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getAll() {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>>
		(this.jobAdvertisementDao.getJobAdvertisementWithEmployerAndJobPositionDetails(),
				Messages.listJobAdvertisement);
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		if (this.employerDao.getById(jobAdvertisement.getEmployer().getId()) == null) {
			return new ErrorResult(Messages.employerDoesNotExist);
		}
		
		if (this.jobPositionDao.getById(jobAdvertisement.getJobPosition().getId()) == null) {
			return new ErrorResult(Messages.jobPositionDoesNotExist);
		}
		
		if (!JobAdvertisementValidator.jobDescriptionIsRequired(jobAdvertisement.getJobDescription())) {
			return new ErrorResult(Messages.jobDescriptionIsRequired);
		}
		
		if (this.cityDao.getById(jobAdvertisement.getCity().getId()) == null) {
			return new ErrorResult(Messages.cityDoesNotExist);
		}
		
		if (!JobAdvertisementValidator.openPositionCountGreaterThanZero(jobAdvertisement.getOpenPositionCount())) {
			return new ErrorResult(Messages.openPositionCountGreaterThanZero);
		}
		
		if (!JobAdvertisementValidator.deadLineIsRequired(jobAdvertisement.getDeadLine())) {
			return new ErrorResult(Messages.deadLineIsRequired);
		}
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(Messages.addJobAdvertisement);
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "release_date");
		return new SuccessDataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>>
		(this.jobAdvertisementDao.getAllSorted(sort), "Başarılı");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getByJobDescriptionAndEmployer(String jobDescription, int employerId) {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>>
		(this.jobAdvertisementDao.getByJobDescriptionAndEmployer(jobDescription, employerId), Messages.listJobAdvertisementByCompanyName);
	}

	@Override
	public Result closeJobAdvertisementByEmployerId(int employerId) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getByEmployer(employerId);
		jobAdvertisement.setIsActive(false);
		return new SuccessResult(Messages.closedJobAdvertisement);
	}
	
}
