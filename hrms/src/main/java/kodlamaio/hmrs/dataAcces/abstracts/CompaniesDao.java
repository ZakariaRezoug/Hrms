package kodlamaio.hmrs.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.Candidates;
import kodlamaio.hmrs.entities.concretes.Companies;
@Repository
public interface CompaniesDao extends JpaRepository<Companies, Integer> {
	Companies findByEmailEquals(String email);
	Companies findByWebSiteEquals(String webSite);
}
