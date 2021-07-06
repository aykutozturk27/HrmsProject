package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getAll();
	DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getByJobDescriptionAndEmployer(String jobDescription, int employerId);
	DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getAllSorted();
	Result add(JobAdvertisement jobAdvertisement);
	Result closeJobAdvertisementByEmployerId(int employerId);
	
}
