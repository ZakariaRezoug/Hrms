package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.auditing.CurrentDateTimeProvider;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvLanguage"})

public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cvId;
	
//	@Column(name="user_id")
//	private int candidateId;
	
	@Column(name="details")
	private String details;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="last_update_date")
	private LocalDate lastUpdateDate;
	
	@Column(name="made_date")
	private LocalDate madeDate ;
	
	@OneToMany(mappedBy = "cv")
	
	private List<CvLanguage> cvLanguage;
	
	@OneToMany(mappedBy = "cv")
	
	private List<CvSchool> cvSchool;
	
	@OneToMany(mappedBy = "cv")
	
	private List<CvExperience> cvExperience;
	
	@OneToMany(mappedBy = "cv")
	
	private List<CvLink> cvLink;
	
	@OneToMany(mappedBy = "cv")
	
	private List<CvPhoto> cvPhoto;
	
	@OneToMany(mappedBy = "cv")
	
	private List<ProgramingTechnology> programingTechnology;
	
	@OneToOne()
	@JsonIgnore()
	@JoinColumn(name = "user_id")
    private Candidate candidate;
}
