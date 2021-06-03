package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvLinkService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAcces.abstracts.CvLinkDao;
import kodlamaio.hmrs.entities.concretes.Cv;
import kodlamaio.hmrs.entities.concretes.CvLink;
import kodlamaio.hmrs.entities.dtos.CvDto;
@Service
public class CvLinkManager implements CvLinkService{
	private CvLinkDao cvLinkDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public CvLinkManager(CvLinkDao cvLinkDao, ModelMapper modelMapper) {
		super();
		this.cvLinkDao = cvLinkDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CvDto cvDto) {
		CvLink cvLink = this.modelMapper.map(cvDto, CvLink.class);
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Cv eklendi.");
	}
	
	private List<CvDto> dtoGenerator(List<CvLink> posting){
        return posting.stream().map(adv-> modelMapper.map(adv,CvDto.class)).collect(Collectors.toList());
        }

	@Override
	public Result addAll(List<CvLink> cvLinks) {
		this.cvLinkDao.saveAll(cvLinks);
		return new SuccessResult("Cv eklendi.");
	}
}
