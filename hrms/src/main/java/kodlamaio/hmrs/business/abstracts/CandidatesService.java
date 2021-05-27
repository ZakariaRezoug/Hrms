package kodlamaio.hmrs.business.abstracts;

import java.util.List;



import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;


public interface CandidatesService {
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	
}
