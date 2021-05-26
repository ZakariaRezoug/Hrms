package kodlamaio.hmrs.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.Job;
@Repository
public interface JobDao extends JpaRepository<Job, Integer> {
	Job findByjobTitleEquals(String jobTitle);
=======

import kodlamaio.hmrs.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer> {

>>>>>>> branch 'master' of https://github.com/ZakariaRezoug/Hrms
}
