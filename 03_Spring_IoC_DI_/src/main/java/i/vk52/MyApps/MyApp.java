package i.vk52.MyApps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import i.vk52.beans.UserService;

public class MyApp {
	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("spring-beans.xml");
		UserService userService = ctxt.getBean(UserService.class);
		userService.saveUser("VamsiKrishna","@Vamsi2k1", 9704960732l);
	}
}
