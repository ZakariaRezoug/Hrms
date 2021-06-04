package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvSchoolService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CvSchoolDao;

import kodlamaio.hmrs.entities.concretes.CvSchool;
import kodlamaio.hmrs.entities.dtos.CvDto;

@Service
public class CvSchoolManager implements CvSchoolService {
	private CvSchoolDao cvSchoolDao;

	
	@Autowired
	public CvSchoolManager(CvSchoolDao cvSchoolDao) {
		super();
		this.cvSchoolDao = cvSchoolDao;
		
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CvSchool cvSchool) {
		
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("Cv eklendi.");
	}
	


	@Override
	public Result addAll(List<CvSchool> cvSchools) {
		this.cvSchoolDao.saveAll(cvSchools);
		return new SuccessResult("Cv eklendi.");
	}

	@Override
	public DataResult<List<CvSchool>> getByCandidateIdOrderBySchoolBeginingDate(int id) {
		
		return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.getByCandidateIdOrderBySchoolBeginingDate(id), "Okullar listelendi.");
	}
	
}
