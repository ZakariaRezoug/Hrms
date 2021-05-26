package kodlamaio.hmrs.core.adapters.abstracts;

import kodlamaio.hmrs.entities.concretes.Companies;


public interface EmployeeValidationService {
	boolean isValidatedByEmployee(Companies company);
}
