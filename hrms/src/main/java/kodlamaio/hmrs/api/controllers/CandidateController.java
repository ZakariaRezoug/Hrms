package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CandidatesService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Candidates;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
	
	private CandidatesService candidatesService;
	
	@Autowired
	public CandidateController(CandidatesService candidatesService) {
		super();
		this.candidatesService = candidatesService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidates>> getAll(){
		
		return this.candidatesService.getAll();
				
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidates candidate) {
		return this.candidatesService.add(candidate);
	}
	

}
