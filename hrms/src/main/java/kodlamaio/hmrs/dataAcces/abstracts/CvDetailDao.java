package kodlamaio.hmrs.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvDetail;
import kodlamaio.hmrs.entities.concretes.CvLanguage;

public interface CvDetailDao extends JpaRepository<CvDetail, Integer> {
	List<CvDetail> getByCandidateId(int id);
}
