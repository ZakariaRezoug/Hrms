package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Table(name = "candidates")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationalty_id")
	private String nationaltyId;

	@Column(name = "birth_year")
	private String birthYear;

	public Candidate(int id, String email, String password, String firstName, 
			String lastName, String nationaltyId,String birthYear) {
		
		super(id,email,password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationaltyId = nationaltyId;
		this.birthYear = birthYear;
		
	}

}
