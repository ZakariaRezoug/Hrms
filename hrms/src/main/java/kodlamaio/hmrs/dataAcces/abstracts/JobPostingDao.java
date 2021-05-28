package kodlamaio.hmrs.dataAcces.abstracts;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	/*List<JobPosting> getByLastApplyDate(LocalDate lastApplyDate);*/
	
	List<JobPosting> getByCompany_companyName(String companyName);
}
