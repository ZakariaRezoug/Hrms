package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.business.abstracts.CvDetailService;
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

import kodlamaio.hmrs.dataAcces.abstracts.CvExperienceDao;
import kodlamaio.hmrs.dataAcces.abstracts.CvLanguageDao;
import kodlamaio.hmrs.dataAcces.abstracts.CvLinkDao;
import kodlamaio.hmrs.dataAcces.abstracts.CvPhotoDao;
import kodlamaio.hmrs.dataAcces.abstracts.CvSchoolDao;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.concretes.CvExperience;
import kodlamaio.hmrs.entities.concretes.CvLanguage;
import kodlamaio.hmrs.entities.concretes.CvLink;
import kodlamaio.hmrs.entities.concretes.CvPhoto;
import kodlamaio.hmrs.entities.concretes.CvSchool;
import kodlamaio.hmrs.entities.dtos.CvDto;

@Service
public class CvManager implements CvService {


	private CvExperienceService cvExperienceService;
	private CvLanguageService cvLanguageService;
	private CvLinkService cvLinkService;
	private CvPhotoService cvPhotoService;
	private CvSchoolService cvSchoolService;
	private CandidateService candidateService;
	private CvDetailService cvDetailService;
	

	@Autowired
	public CvManager(CvExperienceService cvExperienceService,
			CvLanguageService cvLanguageService, CvLinkService cvLinkService, CvPhotoService cvPhotoService,
			CvSchoolService cvSchoolService, CandidateService candidateService,CvDetailService cvDetailService) {
		super();
//		this.cvDao = cvDao;
		this.cvDetailService = cvDetailService;
		this.cvExperienceService = cvExperienceService;
		this.cvLanguageService = cvLanguageService;
		this.cvLinkService = cvLinkService;
		this.cvPhotoService = cvPhotoService;
		this.cvSchoolService = cvSchoolService;
		this.candidateService = candidateService;

	}



	@Override
	public Result add(CvDto cvDto, int id) {
		Candidate candidate = candidateService.getById(id).getData();
        cvDto.setCandidate(candidate);
			
		cvDto.getCvExperience().forEach(cvExperience -> cvExperience.setCandidate(candidate));
        cvExperienceService.addAll(cvDto.getCvExperience());

        cvDto.getCvDetail().forEach(cvDetail -> cvDetail.setCandidate(candidate));
        cvDetailService.addAll(cvDto.getCvDetail());

        cvDto.getCvLanguage().forEach(cvLanguage -> cvLanguage.setCandidate(candidate));
        cvLanguageService.addAll(cvDto.getCvLanguage());
        
        
        cvDto.getCvLink().forEach(cvLink -> cvLink.setCandidate(candidate));
        cvLinkService.addAll(cvDto.getCvLink());

        cvDto.getCvPhoto().forEach(cvPhoto -> cvPhoto.setCandidate(candidate));
        cvPhotoService.addAll(cvDto.getCvPhoto());
        
        cvDto.getCvSchool().forEach(cvSchool -> cvSchool.setCandidate(candidate));
        cvSchoolService.addAll(cvDto.getCvSchool());
        

		

		return new SuccessResult("Cv eklendi.");
	}



}
