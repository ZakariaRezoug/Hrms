package kodlamaio.hmrs.core.utilities.adapters.abstracts;

import kodlamaio.hmrs.entities.concretes.Company;


public interface EmployeeValidationService {
	boolean isValidatedByEmployee(Company company);
}
