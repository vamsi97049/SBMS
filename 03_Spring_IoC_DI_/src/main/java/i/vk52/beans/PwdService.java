package i.vk52.beans;

import java.util.Base64;
import java.util.Base64.Encoder;

public class PwdService {

	public PwdService() {
		System.out.println("PwdService::instantiation successful....");
	}
	public String encodePwd(String pwd) {
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(pwd.getBytes());
	}
}
