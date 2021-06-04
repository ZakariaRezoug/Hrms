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
@Table(name="cv_schools")
public class CvSchool {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_schools_id")
	private int cvSchoolId;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="school_type")
	private String schoolType;
	
	@Column(name="school_departmant")
	private String schoolDepartmant;
	
	@Column(name="school_begining_date")
	private LocalDate schoolBeginingDate;
	
	@Column(name="school_graduation_date")
	private LocalDate schoolGradiationDate;
	

	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name = "user_id")
	private Candidate candidate;
	
	
}
