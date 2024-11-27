package i.vk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import i.vk.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserService userService = context.getBean(UserService.class);
//		userService.deleteAllUsers();
//		userService.saveUser(); // UPSERT
//		userService.saveAllUsers();
//		userService.getAllUsers();
//		userService.getUserById(565);
//		userService.deleteUserById(553);
		userService.getUsersByCountry("India");
	}

}
