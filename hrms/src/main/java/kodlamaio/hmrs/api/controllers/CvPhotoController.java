package kodlamaio.hmrs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.CvPhotoService;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.entities.concretes.CvPhoto;

@RestController
@RequestMapping("/api/cvPhotoController")
public class CvPhotoController {
	
	private CvPhotoService cvPhotoService;
	
	@Autowired
	public CvPhotoController(CvPhotoService cvPhotoService) {
		super();
		this.cvPhotoService = cvPhotoService;
	}
	
	public Result add(@RequestBody CvPhoto cvPhoto,MultipartFile imageFile) {
		
		this.cvPhotoService.add(cvPhoto,imageFile);
		return new SuccessResult("Foto eklendi");
	}
	
}
