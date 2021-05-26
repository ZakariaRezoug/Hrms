package kodlamaio.hmrs.business.abstracts;

import java.util.List;



import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Candidates;


public interface CandidatesService {
	DataResult<List<Candidates>> getAll();
	Result add(Candidates candidate);
	
}
