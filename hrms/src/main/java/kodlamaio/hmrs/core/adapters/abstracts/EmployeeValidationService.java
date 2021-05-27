package kodlamaio.hmrs.core.adapters.abstracts;

import kodlamaio.hmrs.entities.concretes.Company;


public interface EmployeeValidationService {
	boolean isValidatedByEmployee(Company company);
}
