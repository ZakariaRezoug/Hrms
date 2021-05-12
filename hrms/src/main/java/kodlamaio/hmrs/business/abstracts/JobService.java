package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.entities.concretes.Job;

public interface JobService {
	List<Job> getAll();
}
