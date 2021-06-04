package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvLinkService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CvLinkDao;
import kodlamaio.hmrs.entities.concretes.CvLink;
import kodlamaio.hmrs.entities.dtos.CvDto;
@Service
public class CvLinkManager implements CvLinkService{
	private CvLinkDao cvLinkDao;
	
	
	@Autowired
	public CvLinkManager(CvLinkDao cvLinkDao) {
		super();
		this.cvLinkDao = cvLinkDao;
	
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CvLink cvLink) {
		
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Cv eklendi.");
	}
	


	@Override
	public Result addAll(List<CvLink> cvLinks) {
		this.cvLinkDao.saveAll(cvLinks);
		return new SuccessResult("Cv eklendi.");
	}

	@Override
	public SuccessDataResult<List<CvLink>> getByCandidateId(int id) {
		
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getByCandidateId(id), null);
	}
}
