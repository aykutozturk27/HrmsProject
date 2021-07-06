package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.mernis.FakeMernisManager;

@Service
public class MernisAdapter implements MernisService {

	@Override
	public boolean isValidNationalIdentity(Candidate candidate) {
		FakeMernisManager manager = new FakeMernisManager();
		boolean isValidate = manager.ValidateCandidate(candidate.getNationalIdentity(), candidate.getFirstName(), 
				candidate.getLastName(), candidate.getBirthDate().getYear());
		if (isValidate) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
