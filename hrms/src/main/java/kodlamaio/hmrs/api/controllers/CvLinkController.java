package kodlamaio.hmrs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvLinkService;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.entities.concretes.CvLink;

@RestController
@RequestMapping("/api/cvLinkController")
public class CvLinkController {
	
	private CvLinkService cvLinkService;

	@Autowired
	public CvLinkController(CvLinkService cvLinkService) {
		super();
		this.cvLinkService = cvLinkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvLink cvLink) {
		this.cvLinkService.add(cvLink);
		return new SuccessResult("Link eklendi");
	}
}
