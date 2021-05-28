package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobPostingService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobPosting;
@RestController
@RequestMapping("/api/jobPostingController")
public class JobPostingController {
	
	private JobPostingService jobPostingService;
	
	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	@GetMapping("/getAllByIsActive")
	public DataResult<List<JobPosting>> getByisActiveTrue(){
		
		return this.jobPostingService.getByisActiveTrue();
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		
		return this.jobPostingService.add(jobPosting);
	}
	@PostMapping("/delete")
	public Result delete(int id) {
		
		return this.jobPostingService.delete(id);
	}
	@PostMapping("/update")
	public Result update(JobPosting jobPosting) {
		return this.jobPostingService.update(jobPosting);
	}
	@GetMapping("/getAllIsActiveAndSortByLastDate")
	public DataResult<List<JobPosting>> getByIsActiveTrueOrderByPostedDate(){
		return this.jobPostingService.getByIsActiveTrueOrderByPostedDate();
	}
	@GetMapping("/getAllByCompanyNameAndIsActive")
	public DataResult<List<JobPosting>> getByisActiveAndCompanyName(String companyName){
		return this.jobPostingService.getByisActiveTrueAndCompany_companyName(companyName);
	}
	

}
