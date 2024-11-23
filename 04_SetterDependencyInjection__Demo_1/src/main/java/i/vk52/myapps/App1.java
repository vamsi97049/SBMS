package i.vk52.myapps;

import i.vk52.beans.classes.Login;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("beans-xml.xml");
		Login bean1 = ctxt.getBean(Login.class);
		bean1.getConnection("SL0386", "Vara1784#2k1");
	}
}
