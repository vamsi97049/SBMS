package i.vk52.beans;

public class UserService {
	private IEmailService emailService;
	private IUserDao userDao;
	private IPwdService pwdService;
	
	// constructor injection
	public UserService(IEmailService emailService, IUserDao userDao, IPwdService pwdService) {
		this.emailService = emailService;
		this.userDao = userDao;
		this.pwdService = pwdService;
	}
	
	public void userRegistration() {
		pwdService.pwdGenerator();
		userDao.saveUser();
		emailService.sendEmail();
	}
}
