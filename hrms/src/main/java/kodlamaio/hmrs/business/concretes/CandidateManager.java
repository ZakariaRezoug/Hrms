package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CandidatesService;
import kodlamaio.hmrs.core.adapters.abstracts.EmailValidationService;
import kodlamaio.hmrs.core.adapters.abstracts.FakeMernisService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CandidateDao;
import kodlamaio.hmrs.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidatesService {
	
	private CandidateDao candidateDao;
	private FakeMernisService mernis;
	private EmailValidationService emailvalid;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,FakeMernisService mernis,EmailValidationService emailvalid) {
		super();
		this.candidateDao = candidateDao;
		this.mernis = mernis;
		this.emailvalid = emailvalid;
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



	

}
