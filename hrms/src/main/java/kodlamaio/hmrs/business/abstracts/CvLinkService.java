package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.entities.concretes.CvExperience;
import kodlamaio.hmrs.entities.concretes.CvLanguage;
import kodlamaio.hmrs.entities.concretes.CvLink;
import kodlamaio.hmrs.entities.dtos.CvDto;

public interface CvLinkService {
	DataResult<List<CvDto>> getAll();
	Result add(CvLink cvLink);
	Result addAll(List<CvLink> cvLinks);
	SuccessDataResult<List<CvLink>> getByCandidateId(int id);
}
