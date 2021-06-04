package kodlamaio.hmrs.core.utilities.adapters.abstracts;

import kodlamaio.hmrs.entities.concretes.User;

public interface FakeMernisService {
	boolean checkUser(String nationaltyId, String firstName,String lastName,String dateOfBirth);

}
