package kodlamaio.hmrs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvSchoolService;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.entities.concretes.CvSchool;

@RestController
@RequestMapping("/api/cvSchool")
public class CvSchoolController {
	private CvSchoolService cvSchoolService;

	@Autowired
	public CvSchoolController(CvSchoolService cvSchoolService) {
		super();
		this.cvSchoolService = cvSchoolService;
	}
	
	public Result add(CvSchool cvSchool) {
		
		this.cvSchoolService.add(cvSchool);
		return new  SuccessResult("Okul eklendi");
	}

}
