package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CompanyService;
import kodlamaio.hmrs.core.adapters.abstracts.EmailValidationService;
import kodlamaio.hmrs.core.adapters.abstracts.EmployeeValidationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CompaniesDao;

import kodlamaio.hmrs.entities.concretes.Companies;

@Service
public class CompanyManager implements CompanyService {
	private CompaniesDao companyDao;
	private EmailValidationService emailValid;
	private EmployeeValidationService employeeValid;
	
	@Autowired
	public CompanyManager(CompaniesDao companyDao,EmailValidationService emailValid,EmployeeValidationService employeeValid) {
		super();
		this.companyDao = companyDao;
		this.emailValid = emailValid;
		this.employeeValid = employeeValid;
	}


	@Override
	public DataResult<List<Companies>> getAll() {
		
		return new SuccessDataResult<List<Companies>>
		(this.companyDao.findAll() ,"Şirketler listelendi");
	}


	@Override
	public Result add(Companies company) {
		
		if(companyDao.findByEmailEquals(company.getEmail())!= null || companyDao.findByWebSiteEquals(company.getWebSite()) != null) {
			return new ErrorResult("Şirket eklenemedi");
		}
		if(company.getPassword().isEmpty()) {
			return new ErrorResult("Şifre alanı boş bırakılamaz. "+"Kullanıcı eklenemedi");
		}
		if(eMailequalsWebSite(company) != null) {
			return new ErrorResult("Bu eposta adresi domain ile eşleşmiyor. "+"Kullanıcı eklenemedi");
			
		}
		else {
		
		if(!emailValid.isEmailValid(company.getEmail())) {
			return new ErrorResult("Geçersiz bir eposta adresi girdiniz. "+"Kullanıcı eklenemedi");
		}else {
			if(!employeeValid.isValidatedByEmployee(company)) {
				return new ErrorResult("Hesabınız henüz doğrulanmamıştır. "+"Kullanıcı eklenemedi");
			}
			this.companyDao.save(company);
			return new SuccessResult("Başarıyla eklendi");
		}
		}
	}
	private Result eMailequalsWebSite(Companies company) {
        String email = company.getEmail();
        String[] emailSplit = email.split("@");
        if(!emailSplit[1].equals(company.getWebSite())) {
            return new ErrorResult("E-posta ile web domaininiz ayni olmalidir");
        }
        return null;
    }
	}


