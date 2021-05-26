package kodlamaio.hmrs.business.abstracts;

import java.util.List;

<<<<<<< HEAD
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

import kodlamaio.hmrs.entities.concretes.Job;

public interface JobService {
	
	DataResult<List<Job>> getAll();
	Result add(Job job);
=======
import kodlamaio.hmrs.entities.concretes.Job;

public interface JobService {
	List<Job> getAll();
>>>>>>> branch 'master' of https://github.com/ZakariaRezoug/Hrms
}
