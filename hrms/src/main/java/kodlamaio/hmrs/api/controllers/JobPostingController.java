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
	@GetMapping("/getAll")
	public DataResult<List<JobPosting>> getAll(){
		
		return this.jobPostingService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		
		return this.jobPostingService.add(jobPosting);
	}
	@GetMapping("/getAllSortByLastDate")
	public DataResult<List<JobPosting>> sortByLastDate(){
		return this.jobPostingService.sortByLastDate();
	}
	@GetMapping("/getAllByCompanyName")
	public DataResult<List<JobPosting>> getByCompanyName(String companyName){
		return this.jobPostingService.getByCompanyName(companyName);
	}

}
