package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobPostingService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.JobPostingDao;
import kodlamaio.hmrs.entities.concretes.JobPosting;
@Service
public class JobPostingManager implements JobPostingService {
	
	private JobPostingDao jobPostingDao;

	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		
		return new SuccessDataResult<List<JobPosting>>
				(this.jobPostingDao.findAll());
	}

	@Override
	public Result add(JobPosting jobPosting) {
		
		return new SuccessResult(this.jobPostingDao.save(jobPosting)+"İş eklendi");
	}

	@Override
	public DataResult<List<JobPosting>> sortByLastDate() {
		Sort sort = Sort.by(Direction.ASC,"lastApplyDate");
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(sort),"Başarılı");
	}

	@Override
	public DataResult<List<JobPosting>> getByCompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByCompany_companyName(companyName),"Başarılı");
	}

}
