package i.vk52.myapps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import i.vk52.beans.ATM;

public class MyApp {
	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Beans.xml");
		ATM atm1 = ctxt.getBean(ATM.class);
		atm1.withdraw();
	}
}
