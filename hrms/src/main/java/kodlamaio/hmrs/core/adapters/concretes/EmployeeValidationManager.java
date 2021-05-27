package kodlamaio.hmrs.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.adapters.abstracts.EmployeeValidationService;
import kodlamaio.hmrs.entities.concretes.Company;

@Service
public class EmployeeValidationManager implements EmployeeValidationService {

	@Override
	public boolean isValidatedByEmployee(Company company) {
		System.out.println(company.getCompanyName() + " adlı şirket sistem çalışanları tarafından onaylanmıştır.");
		return true;
	}
	
}
