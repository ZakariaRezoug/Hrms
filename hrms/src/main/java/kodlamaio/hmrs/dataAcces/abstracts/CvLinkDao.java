package kodlamaio.hmrs.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvLink;

public interface CvLinkDao extends JpaRepository<CvLink, Integer> {

}
