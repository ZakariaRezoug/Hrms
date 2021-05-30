package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

import kodlamaio.hmrs.entities.concretes.JobPosting;

public interface JobPostingService {
	Result add(JobPosting jobPosting);
	Result delete(int id);
	Result update(JobPosting jobPosting);
	Result setActivetoPassive(int id);
	DataResult<List<JobPosting>> getByisActiveTrue();
	DataResult<List<JobPosting>> getByIsActiveTrueOrderByPostedDate();
	DataResult<List<JobPosting>> getByisActiveTrueAndCompany_companyName(String companyName);
	DataResult<JobPosting> getById(int id);
}
