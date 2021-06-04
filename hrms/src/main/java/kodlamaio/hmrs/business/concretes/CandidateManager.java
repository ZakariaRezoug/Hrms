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
import kodlamaio.hmrs.core.utilities.adapters.abstracts.EmailValidationService;
import kodlamaio.hmrs.core.utilities.adapters.abstracts.FakeMernisService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CandidateDao;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.dtos.CvDto;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private FakeMernisService mernis;
	private EmailValidationService emailvalid;
	private CvExperienceService cvExperienceService;
	private CvLanguageService cvLanguageService;
	private CvLinkService cvLinkService;
	private CvPhotoService cvPhotoService;
	private CvSchoolService cvSchoolService;
	private CvDetailService cvDetailService;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,FakeMernisService mernis,EmailValidationService emailvalid,CvExperienceService cvExperienceService,
			CvLanguageService cvLanguageService,CvLinkService cvLinkService,CvPhotoService cvPhotoService,CvSchoolService cvSchoolService,CvDetailService cvDetailService) {
		super();
		this.candidateDao = candidateDao;
		this.mernis = mernis;
		this.emailvalid = emailvalid;
		this.cvExperienceService = cvExperienceService;
		this.cvLanguageService = cvLanguageService;
		this.cvLinkService = cvLinkService;
		this.cvPhotoService = cvPhotoService;
		this.cvSchoolService = cvSchoolService;
		this.cvDetailService = cvDetailService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"Data listelendi");
		
	}
	

	@Override
	public Result add(Candidate candidate) {
		if(candidateDao.findByEmailEquals(candidate.getEmail())!= null || candidateDao.findByNationaltyIdEquals(candidate.getNationaltyId()) != null) {
			return new ErrorResult("Kullanıcı eklenemedi");
		}
		
		if(!this.mernis.checkUser(candidate.getNationaltyId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear())) {
			return new ErrorResult("Mernis doğrulaması başarısız. "+"Kullanıcı eklenemedi");
		}
		if(candidate.getPassword().isEmpty()) {
			return new ErrorResult("Şifre alanı boş bırakılamaz. "+"Kullanıcı eklenemedi");
		}
		else {
			if(!emailvalid.isEmailValid(candidate.getEmail())) {
				return new ErrorResult("Geçersiz email girdiniz "+"Kullanıcı eklenemedi");
			}
			if(!emailvalid.isEmailValidonclick(candidate.getEmail())) {
				return new ErrorResult("Doğrulama linkine tıklayınız.."+"Kullanıcı eklenemedi");
			}
			else {
			
		this.candidateDao.save(candidate);
		return new SuccessResult("Kullanıcı eklendi");}}
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(id).get());
	}

	@Override
	public DataResult<CvDto> getCvById(int id) {
		CvDto cvDto = new CvDto();
		cvDto.setCandidate(this.getById(id).getData());
		cvDto.setCvExperience(this.cvExperienceService.getByCandidateIdOrderByBeginingDate(id).getData());
		cvDto.setCvLanguage(this.cvLanguageService.getByCandidateId(id).getData());
		cvDto.setCvLink(this.cvLinkService.getByCandidateId(id).getData());
		cvDto.setCvPhoto(this.cvPhotoService.getByCandidateId(id).getData());
		cvDto.setCvSchool(this.cvSchoolService.getByCandidateIdOrderBySchoolBeginingDate(id).getData());
		cvDto.setCvDetail(this.cvDetailService.getByCandidateId(id).getData());
		return new SuccessDataResult<>(cvDto);
	}



	

}
