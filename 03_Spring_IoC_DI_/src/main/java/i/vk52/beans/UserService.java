package i.vk52.beans;

public class UserService {

	private PwdService pwdService;
	
	public UserService() {
		System.out.println("UserService::Instantiation successful..");
		
	}
	
	
	public void setPwdService(PwdService pwdService) {
		System.out.println("SetterInjection invoked to inject dependent object into target");
		this.pwdService = pwdService;
	}
	
	public void saveUser(String name, String password, Long phno) {
		String encodedPassword = pwdService.encodePwd(password);
		System.out.println("Password Encoded : "+encodedPassword);
		System.out.println("Data Saved");
	}
}
