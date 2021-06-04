package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv_details")
public class CvDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_details_id")
	private int cvDetailId;
	
	@Column(name="cv_details")
	private String cvDetails;
	
	@JsonIgnore
	@Column(name= "cv_made_date", columnDefinition = "Date defult CURRENT_DATE")
	private LocalDate madeDate = LocalDate.now();
	
	
	@JsonIgnore
	@Column(name= "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name = "user_id")
	private Candidate candidate;

}
