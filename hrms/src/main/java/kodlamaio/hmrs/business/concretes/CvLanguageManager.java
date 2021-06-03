package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvLanguageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CvLanguageDao;
import kodlamaio.hmrs.entities.concretes.Cv;
import kodlamaio.hmrs.entities.concretes.CvLanguage;
import kodlamaio.hmrs.entities.dtos.CvDto;

@Service
public class CvLanguageManager implements CvLanguageService {
	private CvLanguageDao cvLanguageDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao, ModelMapper modelMapper) {
		super();
		this.cvLanguageDao = cvLanguageDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CvDto cvDto) {
		CvLanguage cvLanguage = this.modelMapper.map(cvDto, CvLanguage.class);	
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Cv eklendi.");
	}
	private List<CvDto> dtoGenerator(List<CvLanguage> posting){
        return posting.stream().map(adv-> modelMapper.map(adv,CvDto.class)).collect(Collectors.toList());
        }

	@Override
	public Result addAll(List<CvLanguage> cvLanguages) {
		this.cvLanguageDao.saveAll(cvLanguages);
		return new SuccessResult("Cv eklendi.");
	}

}
