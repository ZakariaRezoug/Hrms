package kodlamaio.hmrs.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvExperience;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer> {

}
