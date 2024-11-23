package i.vk52.beans.classes;

public class UserService {
	
	PwdService pwdService;
	
	public UserService() {
		System.out.println("UserService::Default Constructor Called");
	}
	
	
	public UserService(PwdService pwdService) {
		this.pwdService = pwdService;
	}



	public void saveUser(String emailId,String pwd) {
		String securePwd = pwdService.pwdEncoder(pwd);
		System.out.println("------------------------------\nUserId :: "+emailId+"\nencryptedPwd::"+securePwd);
		System.out.println("User Record Saved");
	}
	
}
