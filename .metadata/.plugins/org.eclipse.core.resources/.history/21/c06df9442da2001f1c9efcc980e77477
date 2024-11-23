package i.vk52.myapps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import i.vk52.beans.Motor;

public class App1 {
	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Beans.xml");
		Motor motor = ctxt.getBean(Motor.class);
		motor.service();
		ConfigurableApplicationContext cctxt = (ConfigurableApplicationContext)ctxt;
		cctxt.close();
	}
}
