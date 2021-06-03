package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="language_level")

public class LanguageLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_level_id")
	private int languageLevelId;
	
	@Column(name="language_level")
	private int languageLevel;
	
	@OneToOne(mappedBy = "languageLevel")
    private CvLanguage cvLanguage;
}
