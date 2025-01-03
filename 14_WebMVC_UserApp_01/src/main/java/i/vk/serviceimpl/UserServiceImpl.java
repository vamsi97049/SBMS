package i.vk.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import i.vk.entity.User;
import i.vk.iservice.IUserService;
import i.vk.repo.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public boolean saveUser(User user) {
		User save = userRepo.save(user);
		if(save!=null) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<User> getAllUsers() {
		
		return userRepo.findAll();
	}
	
	@Override
	public User editUser(Integer uid) {
		
		if(userRepo.existsById(uid)) {
			Optional<User> byId = userRepo.findById(uid);
			return byId.get();
		}		
		return null;
	}
	@Override
	public boolean checkUserId(Integer uid) {
		if(userRepo.existsById(uid)) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteUser(Integer uid) {
		
		if(userRepo.existsById(uid)) {
			userRepo.deleteById(uid);
			return true;
		}		
		return false;
	}
}
