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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv_links")
public class CvLink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_link_id")
	private int cvLinkId;
	
//	@Column(name="cv_id")
//	private int cvId;
	
	@Column(name="link_name")
	private String linkName;
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name = "cv_id")
	private Cv cv;
}
