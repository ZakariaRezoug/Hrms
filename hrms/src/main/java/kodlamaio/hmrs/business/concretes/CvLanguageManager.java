package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvLanguageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CvLanguageDao;
import kodlamaio.hmrs.entities.concretes.CvLanguage;
import kodlamaio.hmrs.entities.dtos.CvDto;

@Service
public class CvLanguageManager implements CvLanguageService {
	private CvLanguageDao cvLanguageDao;

	
	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		super();
		this.cvLanguageDao = cvLanguageDao;
	
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CvLanguage cvLanguage) {
		
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Cv eklendi.");
	}


	@Override
	public Result addAll(List<CvLanguage> cvLanguages) {
		this.cvLanguageDao.saveAll(cvLanguages);
		return new SuccessResult("Cv eklendi.");
	}

	@Override
	public SuccessDataResult<List<CvLanguage>> getByCandidateId(int id) {
		
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.getByCandidateId(id), "Diller alındı");
	}

}
