package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Cv;
import kodlamaio.hmrs.entities.dtos.CvDto;

public interface CvService {
	DataResult<List<CvDto>> getAll();
	Result add(CvDto cvDto,int id);
}
