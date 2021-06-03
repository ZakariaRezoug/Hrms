package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvPhotoService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CvPhotoDao;
import kodlamaio.hmrs.entities.concretes.Cv;
import kodlamaio.hmrs.entities.concretes.CvPhoto;
import kodlamaio.hmrs.entities.dtos.CvDto;

@Service
public class CvPhotoManager implements CvPhotoService {
	private CvPhotoDao cvPhotoDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public CvPhotoManager(CvPhotoDao cvPhotoDao, ModelMapper modelMapper) {
		super();
		this.cvPhotoDao = cvPhotoDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CvDto cvDto) {
		CvPhoto cvPhoto = this.modelMapper.map(cvDto, CvPhoto.class);
		this.cvPhotoDao.save(cvPhoto);
		return new SuccessResult("Cv eklendi.");
	}
	
	private List<CvDto> dtoGenerator(List<CvPhoto> posting){
        return posting.stream().map(adv-> modelMapper.map(adv,CvDto.class)).collect(Collectors.toList());
        }

	@Override
	public Result addAll(List<CvPhoto> cvPhotos) {
			this.cvPhotoDao.saveAll(cvPhotos);
			return new SuccessResult("Cv eklendi.");
	}


}
