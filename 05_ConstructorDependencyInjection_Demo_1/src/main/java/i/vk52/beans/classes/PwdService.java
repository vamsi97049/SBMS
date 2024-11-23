package i.vk52.beans.classes;

import java.util.Base64;
import java.util.Base64.Encoder;

public class PwdService {

	public PwdService() {
		System.out.println("PwdService::Default Constructor Called");
	}
	
	public String pwdEncoder(String userPwd) {
		Encoder encoder = Base64.getEncoder();
		String secretePwd = encoder.encodeToString(userPwd.getBytes());
		return secretePwd;
	}
	
}
