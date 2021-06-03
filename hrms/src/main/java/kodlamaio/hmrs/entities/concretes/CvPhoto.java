package kodlamaio.hmrs.entities.concretes;

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
@Table(name="cv_photo")
public class CvPhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_photo_id")
	private int cvPhotoId;
	
//	@Column(name="cv_id")
//	private int cvId;
	
	@Column(name="photo")
	private String photo;
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name = "cv_id")
	private Cv cv;
}
