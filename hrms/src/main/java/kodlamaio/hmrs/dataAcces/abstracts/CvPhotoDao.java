package kodlamaio.hmrs.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hmrs.entities.concretes.CvPhoto;

public interface CvPhotoDao extends JpaRepository<CvPhoto, Integer> {
	List<CvPhoto> getByCandidateId(int id);
}
