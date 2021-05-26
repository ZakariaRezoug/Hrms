package kodlamaio.hmrs.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.Candidates;
@Repository
public interface CandidateDao extends JpaRepository<Candidates, Integer> {
	Candidates findByEmailEquals(String email);
	Candidates findByNationaltyIdEquals(String nationaltyId);
	
}
