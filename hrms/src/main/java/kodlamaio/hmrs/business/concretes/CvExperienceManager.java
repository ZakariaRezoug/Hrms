package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvExperienceService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CvExperienceDao;
import kodlamaio.hmrs.entities.concretes.CvExperience;
import kodlamaio.hmrs.entities.dtos.CvDto;
@Service
public class CvExperienceManager implements CvExperienceService {
	
	private CvExperienceDao cvExperienceDao;
	

	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao) {
		super();
		this.cvExperienceDao = cvExperienceDao;
		
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		
		return null;
	}

	@Override
	public Result add(CvExperience cvExperience) {
		
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("Cv eklendi.");
	}
	


	@Override
	public Result addAll(List<CvExperience> cvExperince) {
		this.cvExperienceDao.saveAll(cvExperince);
		return new SuccessResult("Cv eklendi.");
	}

	@Override
	public SuccessDataResult<List<CvExperience>> getByCandidateIdOrderByBeginingDate(int id) {
		
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getByCandidateIdOrderByBeginingDate(id),"Tecrübe listelendi.");
	}


	

}
