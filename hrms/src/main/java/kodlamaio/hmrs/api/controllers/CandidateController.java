package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
	
	private CandidateService candidatesService;
	
	@Autowired
	public CandidateController(CandidateService candidatesService) {
		super();
		this.candidatesService = candidatesService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		
		return this.candidatesService.getAll();
				
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidatesService.add(candidate);
	}
	@GetMapping("/getCv")
	public DataResult<CvDto> getCvById(@RequestParam int id){
		return (this.candidatesService.getCvById(id));
	}
	

}
