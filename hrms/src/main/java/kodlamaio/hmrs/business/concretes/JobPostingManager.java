package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.hibernate.sql.Delete;
import org.hibernate.sql.Update;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


import kodlamaio.hmrs.business.abstracts.JobPostingService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.JobPostingDao;
import kodlamaio.hmrs.entities.concretes.JobPosting;
import net.bytebuddy.asm.Advice.This;
@Service
public class JobPostingManager implements JobPostingService {
	
	private JobPostingDao jobPostingDao;

	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş eklendi");
	}
	
	@Override
	public Result delete(int id) {
		if(!getById(id).getData().isActive()) {
		this.jobPostingDao.deleteById(id);
		return new SuccessResult("İş ilanı kaldırıldı");}
		else {
			return new ErrorResult("İş ilanı aktif olduğu için kaldırılamadı.");
		}
	}
	
	@Override
	public Result update(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı güncellendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByisActiveTrue() {
	
		return new SuccessDataResult<List<JobPosting>>
				(this.jobPostingDao.getByisActiveTrue(),"Tüm aktif ilanlar listelendi");
	}
	
	@Override
	public DataResult<List<JobPosting>> getByIsActiveTrueOrderByPostedDate() {
		
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByIsActiveTrueOrderByPostedDate(),"Başarılı");
	}

	@Override
	public DataResult<List<JobPosting>> getByisActiveTrueAndCompany_companyName(String companyName) {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByisActiveTrueAndCompany_companyName(companyName),"Başarılı");
	}
	
	@Override
	public DataResult<JobPosting> getById(int id) {
		
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.getOne(id));
	}


	
	

}
