package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.concretes.CvDetail;
import kodlamaio.hmrs.entities.concretes.CvExperience;
import kodlamaio.hmrs.entities.concretes.CvLanguage;
import kodlamaio.hmrs.entities.concretes.CvLink;
import kodlamaio.hmrs.entities.concretes.CvPhoto;
import kodlamaio.hmrs.entities.concretes.CvSchool;
import kodlamaio.hmrs.entities.concretes.ProgramingTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	private Candidate candidate;
	private List<CvDetail> cvDetail;
	private List<CvSchool> cvSchool;
	private List<CvExperience>  cvExperience;
	private List<CvLanguage> cvLanguage;
	private List<CvPhoto> cvPhoto;
	private List<CvLink> cvLink;
	private List<ProgramingTechnology> programingTechnology;
}
