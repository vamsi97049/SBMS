package i.vk.iservice;

import i.vk.entity.LoginSource;

public interface ILoginService {
	public boolean updatePassword(String email, String password);
	public int loginValidation(LoginSource login);
	public boolean saveRecord(LoginSource login);
	public boolean checkId(String emilid);
	public int saveOtp(String email);
	public void SendOtp(String email, int otp);
	public boolean validateOtp(String email,int otp);
}
