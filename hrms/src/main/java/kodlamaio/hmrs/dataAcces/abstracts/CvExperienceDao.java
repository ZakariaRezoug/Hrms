package kodlamaio.hmrs.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.entities.concretes.CvExperience;
import kodlamaio.hmrs.entities.concretes.JobPosting;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer> {
	List<CvExperience> getByCandidateIdOrderByBeginingDate(int id);
}
