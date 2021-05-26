package kodlamaio.hmrs.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.Job;
@Repository
public interface JobDao extends JpaRepository<Job, Integer> {
	Job findByjobTitleEquals(String jobTitle);
}
