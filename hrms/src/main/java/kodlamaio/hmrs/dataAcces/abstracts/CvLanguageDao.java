package kodlamaio.hmrs.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvLanguage;

public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer> {

}
