package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.CvPhotoService;
import kodlamaio.hmrs.core.utilities.photoUploader.PhotoUploadService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CvPhotoDao;

import kodlamaio.hmrs.entities.concretes.CvPhoto;
import kodlamaio.hmrs.entities.dtos.CvDto;

@Service
public class CvPhotoManager implements CvPhotoService {
	private CvPhotoDao cvPhotoDao;
	private PhotoUploadService photoUploadService;
	
	@Autowired
	public CvPhotoManager(CvPhotoDao cvPhotoDao,PhotoUploadService photoUploadService) {
		super();
		this.cvPhotoDao = cvPhotoDao;
		this.photoUploadService = photoUploadService;
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CvPhoto cvPhoto,MultipartFile imageFile) {
		Map<String,String> uploadImage = this.photoUploadService.uploadImageFile(imageFile).getData();
		this.cvPhotoDao.save(cvPhoto);
		return new SuccessResult("Cv eklendi.");
	}
	


	@Override
	public Result addAll(List<CvPhoto> cvPhotos) {
			this.cvPhotoDao.saveAll(cvPhotos);
			return new SuccessResult("Cv eklendi.");
	}

	@Override
	public DataResult<List<CvPhoto>> getByCandidateId(int id) {
		
		return new SuccessDataResult<List<CvPhoto>>(this.cvPhotoDao.getByCandidateId(id),"Foto listelendi");
	}


}
