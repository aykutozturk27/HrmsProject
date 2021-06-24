package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

	@Query("From Candidate where email=:email or nationalIdentity=:nationalIdentity")
	Candidate getByEmailOrNationalIdentity(String email, String nationalIdentity);
	
}
