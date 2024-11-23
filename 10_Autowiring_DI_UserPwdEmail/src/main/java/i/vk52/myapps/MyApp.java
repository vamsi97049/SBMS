package i.vk52.myapps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import i.vk52.beans.UserService;

public class MyApp {
	public static void main(String[] args) {
		// IoC container will be invoked when line.No. 11 executed
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Beans.xml");
		UserService user1 = ctxt.getBean(UserService.class);
		user1.userRegistration();
	}
}
