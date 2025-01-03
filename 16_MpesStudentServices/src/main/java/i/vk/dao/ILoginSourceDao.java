package i.vk.dao;

import i.vk.entity.LoginSource;

public interface ILoginSourceDao {
	public int checkSourceRecordWithEmail(String email);
	public boolean saveStudent(LoginSource sourceRecord);
	public boolean loginValidation(String emailId, String password);
	public int obtainOtpService(String emailId);
	public boolean saveOtpService(String emailId, int otp);
	public boolean sendOtpToEmaildId(String emailId);
	public boolean validateOtpRequest(String emailId, int otp);
	public void sendNotificationOnAccountCreation(String emailId);
	public void sendNotificationOnUpdatePassword(String emailId);
	public boolean lockSourceRecordWithEmail(String emailId);
	public boolean unlockSourceRecordWithEmail(String emailId);
	public boolean suspendSourceRecordWithEmail(String emailId);
	public boolean unsuspendSourceRecordWithEmail(String emailId);
	public boolean updatePasswordWithEmailOtp(String emailId,Integer otp);
}
