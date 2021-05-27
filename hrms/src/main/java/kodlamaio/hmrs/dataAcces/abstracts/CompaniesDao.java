package kodlamaio.hmrs.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.concretes.Company;
@Repository
public interface CompaniesDao extends JpaRepository<Company, Integer> {
	Company findByEmailEquals(String email);
	Company findByWebSiteEquals(String webSite);
}
