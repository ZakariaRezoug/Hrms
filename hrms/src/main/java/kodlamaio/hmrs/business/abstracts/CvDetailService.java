package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvDetail;


public interface CvDetailService {
	Result add(CvDetail cvDetail);
	Result addAll(List<CvDetail> cvDetail);
	DataResult<List<CvDetail>> getByCandidateId(int id);
}
