package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvLink;
import kodlamaio.hmrs.entities.concretes.CvPhoto;
import kodlamaio.hmrs.entities.dtos.CvDto;

public interface CvPhotoService {
	DataResult<List<CvDto>> getAll();
	Result add(CvDto cvDto);
	Result addAll(List<CvPhoto> cvPhotos);
}
