package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvExperienceService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CvExperienceDao;
import kodlamaio.hmrs.entities.concretes.Cv;
import kodlamaio.hmrs.entities.concretes.CvExperience;
import kodlamaio.hmrs.entities.dtos.CvDto;
@Service
public class CvExperienceManager implements CvExperienceService {
	
	private CvExperienceDao cvExperienceDao;
	private ModelMapper modelMapper;

	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao,ModelMapper modelMapper) {
		super();
		this.cvExperienceDao = cvExperienceDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		
		return null;
	}

	@Override
	public Result add(CvDto cvDto) {
		CvExperience cvExperience = this.modelMapper.map(cvDto, CvExperience.class);	
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("Cv eklendi.");
	}
	
	private List<CvDto> dtoGenerator(List<CvExperience> posting){
        return posting.stream().map(adv-> modelMapper.map(adv,CvDto.class)).collect(Collectors.toList());
        }

	@Override
	public Result addAll(List<CvExperience> cvExperince) {
		this.cvExperienceDao.saveAll(cvExperince);
		return new SuccessResult("Cv eklendi.");
	}
	

}
