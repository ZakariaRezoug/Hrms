package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="school_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","school"})
public class SchoolType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_type_id")
	private int schoolTypeId;
	
	@Column(name="school_type")
	private String schoolType;
	
	@OneToMany(mappedBy = "schoolType")
	private List<School> school;
}
