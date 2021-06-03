package kodlamaio.hmrs.entities.concretes;

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

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schools")
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_id")
	private int schoolId;
	
	/*@Column(name="school_type_id")
	private int schoolTypeId;*/
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="school_departmant")
	@Nullable
	private String schoolDepartmant;
	
	@ManyToOne()
	@JoinColumn(name = "school_type_id")
	private SchoolType schoolType;
	
	@OneToOne(mappedBy = "school")
	private CvSchool cvSchool;
}
