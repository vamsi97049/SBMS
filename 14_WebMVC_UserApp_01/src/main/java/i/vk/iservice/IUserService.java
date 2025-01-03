package i.vk.iservice;

import java.util.List;

import i.vk.entity.User;

public interface IUserService {
	
	public boolean saveUser(User user);
	
	public List<User> getAllUsers();
	
	public User editUser(Integer uid);
	
	public boolean checkUserId(Integer uid);
	
	public boolean deleteUser(Integer uid);
}
