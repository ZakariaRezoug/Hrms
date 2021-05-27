package kodlamaio.hmrs.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.Employee;
@Repository
public interface EmployeesDao extends JpaRepository<Employee, Integer>{

}
