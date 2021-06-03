package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv_experience")
public class CvExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_experience_id")
	private int cvExperienceId;
	
//	@Column(name="cv_id")
//	private int cvId;
	
//	@Column(name="company_id")
//	private int companyId;
	
	@Column(name="other_company")
	private String otherCompany;
	
	@Column(name="begining_date")
	private LocalDate beginingDate;
	
	@Column(name="ending_date")
	private LocalDate endDate;
	
	@Column(name="cv_experience_name")
	private String cvExperienceName;
	
	@OneToOne()
	@JsonIgnore()
	@JoinColumn(name = "company_id")
	private Company company;
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	
}
