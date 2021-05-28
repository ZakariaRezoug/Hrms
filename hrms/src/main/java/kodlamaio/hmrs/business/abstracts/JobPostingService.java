package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

import kodlamaio.hmrs.entities.concretes.JobPosting;

public interface JobPostingService {
	DataResult<List<JobPosting>> getAll();
	Result add(JobPosting jobPosting);
	DataResult<List<JobPosting>> sortByLastDate();
	DataResult<List<JobPosting>> getByCompanyName(String companyName);
}
