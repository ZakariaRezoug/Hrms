package kodlamaio.hmrs.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.Candidate;
@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate findByEmailEquals(String email);
	Candidate findByNationaltyIdEquals(String nationaltyId);
	
}
