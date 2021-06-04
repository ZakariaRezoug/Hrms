package kodlamaio.hmrs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvLanguageService;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.entities.concretes.CvLanguage;
@RestController
@RequestMapping("/api/cvLanguageController")
public class CvLanguageController {
	private CvLanguageService cvLanguageService;
	
	@Autowired
	public CvLanguageController(CvLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvLanguage cvLanguage) {
		
		this.cvLanguageService.add(cvLanguage);
		return new SuccessResult("Dil eklendi.");
	} 
}
