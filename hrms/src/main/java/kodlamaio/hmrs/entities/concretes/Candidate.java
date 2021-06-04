package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "candidates")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationalty_id")
	private String nationaltyId;

	@Column(name = "birth_year")
	private String birthYear;

	public Candidate(int id, String email, String password, String firstName, String lastName, String nationaltyId,
			String birthYear) {

		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationaltyId = nationaltyId;
		this.birthYear = birthYear;

	}

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CvLanguage> cvLanguage;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CvSchool> cvSchool;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CvExperience> cvExperience;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CvLink> cvLink;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CvPhoto> cvPhoto;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CvDetail> cvDetail;


	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<ProgramingTechnology> programingTechnology;

}
