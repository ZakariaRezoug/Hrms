package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employees;

public interface EmployeeService {
	DataResult<List<Employees>> getAll();
	Result add(Employees employee);
}
