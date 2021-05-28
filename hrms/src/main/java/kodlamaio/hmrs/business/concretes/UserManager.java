package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.dataAcces.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.User;

@Service
public class UserManager implements UserService {

	
	private UserDao  userDao;
	

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}



	@Override
	public List<User> getAll() {
		
		return this.userDao.findAll();
	}

}
