package i.vk.daoimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import i.vk.configurations.EmailService;
import i.vk.configurations.OtpSender;
import i.vk.dao.ILoginSourceDao;
import i.vk.entity.LoginSource;
import i.vk.repository.LoginSourceRepository;
import jakarta.mail.MessagingException;

public class LoginSourceDaoImpl implements ILoginSourceDao {

	@Autowired
	private LoginSourceRepository repoService;

	@Override
	public int checkSourceRecordWithEmail(String email) {
		boolean isPresent = repoService.existsById(email);
		if (isPresent) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean sendOtpToEmaildId(String emailId) {
		EmailService emailService = new EmailService();
		OtpSender otpSource = new OtpSender();
		int otp = otpSource.generateOTP();
		boolean saveOtpService = saveOtpService(emailId, otp);
		if (!saveOtpService) {
			return false;
		}
		String body = "<html>" + "<head>" + "<style>"
				+ "  body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; }"
				+ "  .container { width: 100%; max-width: 600px; margin: 20px auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }"
				+ "  .header { text-align: center; color: #333; }"
				+ "  .otp { font-size: 36px; font-weight: bold; color: #007bff; text-align: center; margin-top: 20px; }"
				+ "  .footer { text-align: center; font-size: 12px; color: #777; margin-top: 20px; }"
				+ "  .note { font-size: 14px; color: #555; }" + "</style>" + "</head>" + "<body>"
				+ "  <div class='container'>" + "    <div class='header'>"
				+ "      <h2>Your One-Time Password (OTP) for Access</h2>" + "    </div>" + "    <div class='otp'>"
				+ otp + "    </div>" + "    <div class='note'>"
				+ "      Please use this OTP to complete your verification. The OTP is valid for 10 minutes."
				+ "    </div>" + "    <div class='footer'>"
				+ "      If you didn't request this, please ignore this email." + "    </div>" + "  </div>" + "</body>"
				+ "</html>" + "";

		try {
			emailService.sendEmail(emailId, "Reset Password OTP", body);
			return true;
		} catch (MessagingException e) {
			return false;
		}
	}

	@Override
	public boolean lockSourceRecordWithEmail(String emailId) {
		Optional<LoginSource> sourceRecord = repoService.findById(emailId);
		if (sourceRecord.get() != null) {
			sourceRecord.get().setIsLocked(1);
			return true;
		}
		return false;
	}

	@Override
	public boolean loginValidation(String emailId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int obtainOtpService(String emailId) {
		Optional<LoginSource> sourceRecord = repoService.findById(emailId);
		if (sourceRecord.get() != null) {
			return sourceRecord.get().getOtp();
		}
		return 0;
	}

	@Override
	public boolean saveStudent(LoginSource sourceRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendNotificationOnAccountCreation(String emailId) {
		EmailService emailService = new EmailService();
		String body = "<html>" + "<head>" + "<style>"
				+ "  body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; }"
				+ "  .container { width: 100%; max-width: 600px; margin: 20px auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }"
				+ "  .header { text-align: center; color: #333; }"
				+ "  .otp { font-size: 36px; font-weight: bold; color: #007bff; text-align: center; margin-top: 20px; }"
				+ "  .footer { text-align: center; font-size: 12px; color: #777; margin-top: 20px; }"
				+ "  .note { font-size: 14px; color: #555; }" + "</style>" + "</head>" + "<body>"
				+ "  <div class='container'>" + "    <div class='header'>"
				+ "      <h2>Your Account has been created.</h2>" + "    <div class='note'>"
				+ "      Please use your credentials for login." + "    </div>" + "    <div class='footer'>"
				+ "      If you didn't request this, please ignore this email." + "    </div>" + "  </div>" + "</body>"
				+ "</html>" + "";

		try {
			emailService.sendEmail(emailId, "Account Created", body);
		} catch (MessagingException e) {
		}

	}

	@Override
	public void sendNotificationOnUpdatePassword(String emailId) {
		EmailService emailService = new EmailService();
		String body = "<html>" + "<head>" + "<style>"
				+ "  body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; }"
				+ "  .container { width: 100%; max-width: 600px; margin: 20px auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }"
				+ "  .header { text-align: center; color: #333; }"
				+ "  .otp { font-size: 36px; font-weight: bold; color: #007bff; text-align: center; margin-top: 20px; }"
				+ "  .footer { text-align: center; font-size: 12px; color: #777; margin-top: 20px; }"
				+ "  .note { font-size: 14px; color: #555; }" + "</style>" + "</head>" + "<body>"
				+ "  <div class='container'>" + "    <div class='header'>"
				+ "      <h2>Your Account Password is updated.</h2>" + "    <div class='note'>"
				+ "      Please use your updated credentials for login." + "    </div>" + "    <div class='footer'>"
				+ "      If you didn't request this, please ignore this email." + "    </div>" + "  </div>" + "</body>"
				+ "</html>" + "";

		try {
			emailService.sendEmail(emailId, "Passowrd Updated", body);
		} catch (MessagingException e) {
		}


	}

	@Override
	public boolean saveOtpService(String emailId, int otp) {
		Optional<LoginSource> sourceRecord = repoService.findById(emailId);
		if (sourceRecord.get() != null) {
			sourceRecord.get().setOtp(otp);
			repoService.save(sourceRecord.get());
			return true;
		}
		return false;
	}

	@Override
	public boolean suspendSourceRecordWithEmail(String emailId) {
		Optional<LoginSource> sourceRecord = repoService.findById(emailId);
		if (sourceRecord.get() != null) {
			sourceRecord.get().setIsSuspended(1);
			return true;
		}
		return false;
	}

	@Override
	public boolean unlockSourceRecordWithEmail(String emailId) {
		Optional<LoginSource> sourceRecord = repoService.findById(emailId);
		if (sourceRecord.get() != null) {
			sourceRecord.get().setIsLocked(0);
			return true;
		}
		return false;
	}

	@Override
	public boolean unsuspendSourceRecordWithEmail(String emailId) {
		Optional<LoginSource> sourceRecord = repoService.findById(emailId);
		if (sourceRecord.get() != null) {
			sourceRecord.get().setIsSuspended(0);
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePasswordWithEmailOtp(String emailId, Integer otp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateOtpRequest(String emailId, int otp) {
		// TODO Auto-generated method stub
		return false;
	}

}
