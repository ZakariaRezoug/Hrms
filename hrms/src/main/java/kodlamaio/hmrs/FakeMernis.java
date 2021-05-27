package kodlamaio.hmrs;

public class FakeMernis {
	public boolean checkUser(String nationaltyId, String firstName, String lastName, String dateOfBirth) {
		FakeMernis fakeMernis = new FakeMernis();
		return fakeMernis.checkUser(nationaltyId, firstName, lastName, dateOfBirth);
	}
	
}
