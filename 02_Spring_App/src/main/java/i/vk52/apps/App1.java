package i.vk52.apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
	public static void main(String[] args) {
		ApplicationContext ctext = new ClassPathXmlApplicationContext("Beans.xml");
		
	}
}
 
