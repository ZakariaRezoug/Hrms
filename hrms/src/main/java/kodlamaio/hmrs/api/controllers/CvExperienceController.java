package kodlamaio.hmrs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvExperienceService;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.entities.concretes.CvExperience;

@RestController
@RequestMapping("/api/cvExperience")
public class CvExperienceController {
	private CvExperienceService cvExperienceService;

	@Autowired
	public CvExperienceController(CvExperienceService cvExperienceService) {
		super();
		this.cvExperienceService = cvExperienceService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody CvExperience cvExperience) {
		this.cvExperienceService.add(cvExperience);
		return new SuccessResult("Başarılı");
	}
}
