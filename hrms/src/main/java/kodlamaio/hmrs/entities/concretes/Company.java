package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "companies")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "company_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobPostings"})
public class Company extends User {
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_site")
	private String webSite;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "company")
	private List<JobPosting> jobPostings;
	
	public Company(int id,String email,String password,String companyName,String webSite,String phoneNumber) {
		
		super(id,email,password);
		this.companyName = companyName;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
		
	}

}
