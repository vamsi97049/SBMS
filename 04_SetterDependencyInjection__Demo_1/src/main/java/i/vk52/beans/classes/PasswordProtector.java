package i.vk52.beans.classes;

import java.util.Base64;
import java.util.Base64.Encoder;

public class PasswordProtector {

	public PasswordProtector() {
		System.out.println("PasswordProtector::Instantiation successful....");
	}
	
	public String protector(String password) {
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(password.getBytes());
	}
	
}
