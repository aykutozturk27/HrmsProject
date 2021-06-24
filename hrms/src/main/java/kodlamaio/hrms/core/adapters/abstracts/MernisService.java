package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisService {

	boolean isValidNationalIdentity(Candidate candidate);
	
}
