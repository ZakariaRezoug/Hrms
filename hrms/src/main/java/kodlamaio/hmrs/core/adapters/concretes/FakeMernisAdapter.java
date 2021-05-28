package kodlamaio.hmrs.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.adapters.abstracts.FakeMernisService;
@Service
public class FakeMernisAdapter implements FakeMernisService {

	@Override
	public boolean checkUser(String nationaltyId, String firstName, String lastName, String dateOfBirth) {
		if(nationaltyId.length()!= 11) {
			System.out.println("Tc kimlik numaranız 11 haneden büyük ve ya küçük.");
			return false;
		}
		if(firstName.length()<2 || lastName.length()<2) {
			System.out.println("Adınız ve ya soyadınız 2 karakterden küçük olamaz.");
			return false;
		}
		if(dateOfBirth.length()!= 4) {
			System.out.println("Doğum tarihinizi lütfen sadece yıl olarak giriniz.");
			return false;
		}
		else {
				System.out.println("Mernis doğrulaması sağlandı.");
				return true;
		}
		
		
	}

}
