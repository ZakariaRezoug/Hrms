package kodlamaio.hmrs.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hmrs.entities.concretes.CvLink;

public interface CvLinkDao extends JpaRepository<CvLink, Integer> {
	List<CvLink> getByCandidateId(int id);
}
