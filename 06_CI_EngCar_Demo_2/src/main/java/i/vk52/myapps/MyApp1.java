package i.vk52.myapps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import i.vk52.beans.classes.Car;



public class MyApp1 {
	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Beans.xml");
		Car car1 = ctxt.getBean(Car.class);
		car1.drive();
	}
}
