package i.vk52.beans;

public class EmailServiceImpl implements IEmailService {
	@Override
	public void sendEmail() {
		System.out.println("Email has been sent to registered email");		
	}
}
