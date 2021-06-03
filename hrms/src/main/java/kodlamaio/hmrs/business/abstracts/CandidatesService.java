package kodlamaio.hmrs.business.abstracts;

import java.util.List;



import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.concretes.JobPosting;


public interface CandidatesService {
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	public DataResult<Candidate> getById(int id);
	
}
