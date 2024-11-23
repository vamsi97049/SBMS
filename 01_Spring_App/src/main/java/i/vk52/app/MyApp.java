package i.vk52.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import i.vk52.beans.DieselEngine;
import i.vk52.beans.PetrolEngine;

public class MyApp {
	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Beans.xml");
		DieselEngine bean1 = ctxt.getBean(DieselEngine.class);
		bean1.start();
		ApplicationContext ctxt1 = new ClassPathXmlApplicationContext("Beans.xml");
		PetrolEngine bean2 = ctxt1.getBean(PetrolEngine.class);
		bean2.start();
	}
}
