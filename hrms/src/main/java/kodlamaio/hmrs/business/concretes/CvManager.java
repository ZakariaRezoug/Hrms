package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CandidatesService;
import kodlamaio.hmrs.business.abstracts.CvExperienceService;
import kodlamaio.hmrs.business.abstracts.CvLanguageService;
import kodlamaio.hmrs.business.abstracts.CvLinkService;
import kodlamaio.hmrs.business.abstracts.CvPhotoService;
import kodlamaio.hmrs.business.abstracts.CvSchoolService;
import kodlamaio.hmrs.business.abstracts.CvService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CvDao;
import kodlamaio.hmrs.dataAcces.abstracts.CvExperienceDao;
import kodlamaio.hmrs.dataAcces.abstracts.CvLanguageDao;
import kodlamaio.hmrs.dataAcces.abstracts.CvLinkDao;
import kodlamaio.hmrs.dataAcces.abstracts.CvPhotoDao;
import kodlamaio.hmrs.dataAcces.abstracts.CvSchoolDao;
import kodlamaio.hmrs.entities.concretes.Cv;
import kodlamaio.hmrs.entities.concretes.CvExperience;
import kodlamaio.hmrs.entities.concretes.CvLanguage;
import kodlamaio.hmrs.entities.concretes.CvLink;
import kodlamaio.hmrs.entities.concretes.CvPhoto;
import kodlamaio.hmrs.entities.concretes.CvSchool;
import kodlamaio.hmrs.entities.dtos.CvDto;

@Service
public class CvManager implements CvService {

	private CvDao cvDao;
	private CvExperienceService cvExperienceService;
	private CvLanguageService cvLanguageService;
	private CvLinkService cvLinkService;
	private CvPhotoService cvPhotoService;
	private CvSchoolService cvSchoolService;
	private CandidatesService candidateService;
	private ModelMapper modelMapper;

	@Autowired
	public CvManager(CvDao cvDao, ModelMapper modelMapper, CvExperienceService cvExperienceService,
			CvLanguageService cvLanguageService, CvLinkService cvLinkService, CvPhotoService cvPhotoService,
			CvSchoolService cvSchoolService, CandidatesService candidateService) {
		super();
		this.cvDao = cvDao;
		this.modelMapper = modelMapper;
		this.cvExperienceService = cvExperienceService;
		this.cvLanguageService = cvLanguageService;
		this.cvLinkService = cvLinkService;
		this.cvPhotoService = cvPhotoService;
		this.cvSchoolService = cvSchoolService;
		this.candidateService = candidateService;

	}

	@Override
	public DataResult<List<CvDto>> getAll() {

		return new SuccessDataResult<List<CvDto>>("Data listelendi");
	}

	@Override
	public Result add(CvDto cvDto, int id) {


		cvDto.setCandidate(this.candidateService.getById(id).getData());
		Cv cv = this.modelMapper.map(cvDto, Cv.class);
		this.cvDao.save(cv);

		for (int i = 0; i <= cvDto.getCvExperience().size(); i++) {
			cvDto.setCandidate(this.candidateService.getById(id).getData());
			this.cvExperienceService.addAll(cvDto.getCvExperience());
		}

		for (int i = 0; i <= cvDto.getCvLanguage().size(); i++) {
			cvDto.setCandidate(this.candidateService.getById(id).getData());
			this.cvLanguageService.addAll(cvDto.getCvLanguage());
		}

		for (int i = 0; i <= cvDto.getCvLink().size(); i++) {
			cvDto.setCandidate(this.candidateService.getById(id).getData());
			this.cvLinkService.addAll(cvDto.getCvLink());
		}

		for (int i = 0; i <= cvDto.getCvPhoto().size(); i++) {
			cvDto.setCandidate(this.candidateService.getById(id).getData());
			this.cvPhotoService.addAll(cvDto.getCvPhoto());
		}

		for (int i = 0; i <= cvDto.getCvSchool().size(); i++) {
			cvDto.setCandidate(this.candidateService.getById(id).getData());
			this.cvSchoolService.addAll(cvDto.getCvSchool());
		}

		return new SuccessResult("Cv eklendi.");
	}

//	private List<CvDto> dtoGenerator(List<Cv> posting) {
//		return posting.stream().map(adv -> modelMapper.map(adv, CvDto.class)).collect(Collectors.toList());
//	}

}
