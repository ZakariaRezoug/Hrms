package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvExperience;
import kodlamaio.hmrs.entities.dtos.CvDto;

public interface CvExperienceService {
	DataResult<List<CvDto>> getAll();
	Result add(CvDto cvDto);
	Result addAll(List<CvExperience> cvExperince);
}
