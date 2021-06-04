package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.entities.concretes.CvExperience;
import kodlamaio.hmrs.entities.dtos.CvDto;

public interface CvExperienceService {
	DataResult<List<CvDto>> getAll();
	Result add(CvExperience cvExperience);
	Result addAll(List<CvExperience> cvExperince);
	SuccessDataResult<List<CvExperience>> getByCandidateIdOrderByBeginingDate(int id);
}
