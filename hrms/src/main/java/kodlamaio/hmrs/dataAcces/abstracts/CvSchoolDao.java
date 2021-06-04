package kodlamaio.hmrs.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hmrs.entities.concretes.CvSchool;

public interface CvSchoolDao extends JpaRepository<CvSchool, Integer> {
	List<CvSchool> getByCandidateIdOrderBySchoolBeginingDate(int id);
}
