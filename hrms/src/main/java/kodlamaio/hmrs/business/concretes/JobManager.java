package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobService;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.JobDao;
import kodlamaio.hmrs.entities.concretes.Job;

@Service
public class JobManager implements JobService {
	
	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	

	@Override
	public DataResult<List<Job>> getAll() {
		
		return new SuccessDataResult<List<Job>>
		(this.jobDao.findAll(), "İşler listelendi.");
	}

	@Override
	public Result add(Job job) {
		if(jobDao.findByjobTitleEquals(job.getJobTitle()) != null) {
			return new ErrorResult("Bu iş dalı daha önce eklenmiştir." + " Ekleme başarısız");
		}else {
		this.jobDao.save(job);
		return new SuccessResult("Başarıyla eklendi");}

}}
