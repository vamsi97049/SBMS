package i.vk52.myapps;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import i.vk52.beans.classes.UserService;

public class MyApp1 {
	public static void main(String[] args) {
		String emailId,pwd;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter email Id ::\t");
		emailId = scan.next();
		System.out.print("Enter password ::\t");
		pwd = scan.next();
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Spring-Beans.xml");
		UserService userService = ctxt.getBean(UserService.class);
		userService.saveUser(emailId, pwd);
	}
}
