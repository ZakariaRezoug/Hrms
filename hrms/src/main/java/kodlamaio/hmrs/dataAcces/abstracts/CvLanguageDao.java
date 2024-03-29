package kodlamaio.hmrs.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hmrs.entities.concretes.CvLanguage;

public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer> {
	List<CvLanguage> getByCandidateId(int id);
}
