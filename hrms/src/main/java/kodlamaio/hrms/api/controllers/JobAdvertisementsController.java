package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getByJobDescriptionAndEmployer")
	public DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getByJobDescriptionAndEmployer(String jobDescription, int employerId){
		return this.jobAdvertisementService.getByJobDescriptionAndEmployer(jobDescription,employerId);
	}
	
	@GetMapping("/getallSorted")
	public DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getAllSorted(){
		return this.jobAdvertisementService.getAllSorted();
	}
	
	@PostMapping("/add")
	public Result Add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/closeJobAdvertisementByEmployerId")
	public Result Add(@RequestBody int employerId) {
		return this.jobAdvertisementService.closeJobAdvertisementByEmployerId(employerId);
	}
	
}
