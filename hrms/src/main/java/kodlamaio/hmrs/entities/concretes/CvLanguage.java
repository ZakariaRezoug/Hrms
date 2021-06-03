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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cvLanguage"})
public class CvLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_languages_id")
	private int cvLanguagesId;
	
	/*@Column(name="languages_id")
	private int languagesId;*/
	
	/*@Column(name="language_level_id")
	private int languageLevelId;*/
	
//	@Column(name="cv_id")
//	private int cvId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "languages_id")
    private Language language;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "language_level_id")
	private LanguageLevel languageLevel;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore()
	@JoinColumn(name = "cv_id")
	private Cv cv;
}
