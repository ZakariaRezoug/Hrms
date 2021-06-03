package kodlamaio.hmrs.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvPhoto;

public interface CvPhotoDao extends JpaRepository<CvPhoto, Integer> {

}
