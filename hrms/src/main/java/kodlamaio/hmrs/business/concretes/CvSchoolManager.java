package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvSchoolService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CvSchoolDao;
import kodlamaio.hmrs.entities.concretes.Cv;
import kodlamaio.hmrs.entities.concretes.CvSchool;
import kodlamaio.hmrs.entities.dtos.CvDto;

@Service
public class CvSchoolManager implements CvSchoolService {
	private CvSchoolDao cvSchoolDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public CvSchoolManager(CvSchoolDao cvSchoolDao, ModelMapper modelMapper) {
		super();
		this.cvSchoolDao = cvSchoolDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CvDto cvDto) {
		CvSchool cvSchool = this.modelMapper.map(cvDto, CvSchool.class);
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("Cv eklendi.");
	}
	
	private List<CvDto> dtoGenerator(List<CvSchool> posting){
        return posting.stream().map(adv-> modelMapper.map(adv,CvDto.class)).collect(Collectors.toList());
        }

	@Override
	public Result addAll(List<CvSchool> cvSchools) {
		this.cvSchoolDao.saveAll(cvSchools);
		return new SuccessResult("Cv eklendi.");
	}
	
}
