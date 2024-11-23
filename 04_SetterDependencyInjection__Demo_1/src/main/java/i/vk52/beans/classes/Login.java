package i.vk52.beans.classes;

public class Login {

	private PasswordProtector passwordProtector;
	
	public Login() {
		System.out.println("Login::Instantiation successful...");
	}
	
	public void setPasswordProtector(PasswordProtector passwordProtector) {
		this.passwordProtector = passwordProtector;
	}
	
	public void getConnection(String userId,String password) {
		String encodedPassword = passwordProtector.protector(password);
		System.out.println("EncodedPassword::"+encodedPassword);
		System.out.println("Login record saved successfully...");
	}
}
