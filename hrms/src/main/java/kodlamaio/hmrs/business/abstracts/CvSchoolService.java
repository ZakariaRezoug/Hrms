package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvPhoto;
import kodlamaio.hmrs.entities.concretes.CvSchool;
import kodlamaio.hmrs.entities.dtos.CvDto;

public interface CvSchoolService {
	DataResult<List<CvDto>> getAll();
	Result add(CvSchool cvSchool);
	Result addAll(List<CvSchool> cvSchools);
	DataResult<List<CvSchool>> getByCandidateIdOrderBySchoolBeginingDate(int id);
}
