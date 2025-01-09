package i.vk.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import i.vk.entity.User;
import i.vk.repo.UserRepository;

@Service
public class UserService {
	private UserRepository userRepo;
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
		System.out.println("Implementation Class :: "+userRepo.getClass().getName());
	}
	// SAVE OPERATION SERVICE
	public void saveUser() {
		User user = new User();
		user.setId(553);
		user.setName("Syam Prasad pothineni");
		user.setGender("Male");
		user.setCountry("North America");
		
		userRepo.save(user);  // UPSERT = UPDATE + INSERT
		
	}
	// BASED ON COUNTRY NAME
	public void getUsersByCountry(String country) {
		List<User> byCountry = userRepo.findByCountry(country);
		byCountry.forEach(System.out::println);
	}
	// SAVING MULTIPLE USERS
	public void saveAllUsers() {
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		User user5 = new User();
		List<User> list = new ArrayList<User>();
		user1.setId(554);
		user1.setName("Nepoleon Puppalla");
		user1.setGender("Female");
		user1.setCountry("West Indice");
		user2.setId(555);
		user2.setName("Sampath Rajupalem");
		user2.setGender("Male");
		user2.setCountry("Japan");
		user3.setId(556);
		user3.setName("Syed unchan yohi abki unihaan Sadineni");
		user3.setGender("Male");
		user3.setCountry("Chaina");
		user4.setId(557);
		user4.setName("Venkata Ramaraju Sarikonda");
		user4.setGender("Male");
		user4.setCountry("Tokyo");
		user5.setId(558);
		user5.setName("Amere Suraj");
		user5.setGender("Male");
		user5.setCountry("India");
		userRepo.saveAll(Arrays.asList(user1,user2,user3,user4,user5));		
	}
	// GET ALL USERS
	public void getAllUsers() {
		Iterable<User> all = userRepo.findAll();
		all.forEach(user->{
			System.out.println(user);
		});
	}
	// GET USER BASED ON ID
	public void getUserById(int id) {
		Optional<User> userRecord = userRepo.findById(id);
		if(userRecord.isPresent()) {
			System.out.println(userRecord.get());
		}else {
			System.out.println("No record found with UserId :: "+id);
		}
	}	
	// DELETING ALL RECORDS
	public void deleteAllUsers() {
		userRepo.deleteAll();
	}
	// DELETE USER BASED ON ID
	public void deleteUserById(int id) {
		userRepo.deleteById(id);
	}
}
