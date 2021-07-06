package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("From JobAdvertisement where jobDescription=:jobDescription and employer_id=:employerId")
	List<JobAdvertisementWithEmployerWithJobPositionDto> getByJobDescriptionAndEmployer(String jobDescription, int employerId);
	
	@Query("From JobAdvertisement where employer_id=:employerId")
	JobAdvertisement getByEmployer(int employerId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto"
			+ "(ja.id, e.companyName, jp.title,ja.openPositionCount,ja.releaseDate, ja.deadLine) "
			+ "From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.jobPosition jp")
	List<JobAdvertisementWithEmployerWithJobPositionDto> getJobAdvertisementWithEmployerAndJobPositionDetails();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto"
			+ "(ja.id, e.companyName, jp.title,ja.openPositionCount,ja.releaseDate, ja.deadLine) "
			+ "From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.jobPosition jp")
	List<JobAdvertisementWithEmployerWithJobPositionDto> getAllSorted(Sort sort);

}
