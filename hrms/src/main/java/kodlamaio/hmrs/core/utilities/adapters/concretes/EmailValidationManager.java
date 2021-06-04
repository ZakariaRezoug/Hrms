package kodlamaio.hmrs.core.utilities.adapters.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.utilities.adapters.abstracts.EmailValidationService;
@Service
public class EmailValidationManager implements EmailValidationService {

	@Override
	public boolean isEmailValid(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
		
	}

	@Override
	public boolean isEmailValidonclick(String email) {
		System.out.println("Doğrulama başarılı"+ email);
		return true;
	}

}
