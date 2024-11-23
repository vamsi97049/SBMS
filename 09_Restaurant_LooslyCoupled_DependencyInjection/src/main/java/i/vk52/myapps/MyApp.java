package i.vk52.myapps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import i.vk52.beans.classes.Restaurant;

public class MyApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Beans.xml");
		Restaurant restaurant = ctxt.getBean(Restaurant.class);
		restaurant.payment(1500);
	}
}
