package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvDetailService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CvDetailDao;
import kodlamaio.hmrs.entities.concretes.CvDetail;
@Service
public class CvDetailManager implements CvDetailService{
	private CvDetailDao cvDetailDao;

	@Autowired
	public CvDetailManager(CvDetailDao cvDetailDao) {
		super();
		this.cvDetailDao = cvDetailDao;
	}

	@Override
	public Result add(CvDetail cvDetail) {
		this.cvDetailDao.save(cvDetail);
		return new SuccessResult("Detaylar eklendi.");
	}

	@Override
	public Result addAll(List<CvDetail> cvDetail) {
		this.cvDetailDao.saveAll(cvDetail);
		return new SuccessResult("Detaylar eklendi.");
	}

	@Override
	public DataResult<List<CvDetail>> getByCandidateId(int id) {
		
		return new SuccessDataResult<List<CvDetail>>(this.cvDetailDao.getByCandidateId(id),"Detaylar çekildi");
	}
}
