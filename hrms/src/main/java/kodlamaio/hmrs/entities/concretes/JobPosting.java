package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name ="job_postings")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_details")
	private String jobDetails;
	
	@Column(name = "min_wage")
	private double minWage;
	
	@Column(name = "max_wage")
	private double maxWage;
	
	@Column(name = "number_of_open_position")
	private int numberOfOpenPositions;
	
	@Column(name = "last_apply_date")
	private LocalDate lastApplyDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "posted_date")
	private LocalDate postedDate;
	

	@ManyToOne()
	@JoinColumn(name = "company_id")
	private Company company;
	
	
	@ManyToOne()
	@JoinColumn(name = "job_id")
	private Job job;
	
	
    @ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
}
