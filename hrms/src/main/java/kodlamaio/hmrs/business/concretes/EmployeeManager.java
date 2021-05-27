package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployeeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.EmployeesDao;
import kodlamaio.hmrs.entities.concretes.Employee;
@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeesDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeesDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}


	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>
		(this.employeeDao.findAll(),"Çalışanlar listelendi");
	}

	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Çalışan eklendi");
	}

}
