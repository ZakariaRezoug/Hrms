package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.entities.concretes.User;

public interface UserService {
	List<User> getAll();
}
