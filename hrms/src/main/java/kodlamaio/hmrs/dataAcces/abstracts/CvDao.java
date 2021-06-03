package kodlamaio.hmrs.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer>{
	
}
