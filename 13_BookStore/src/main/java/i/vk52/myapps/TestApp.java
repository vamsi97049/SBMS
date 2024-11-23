package i.vk52.myapps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import i.vk52.beans.BookService;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Beans.xml");
		BookService book = ctxt.getBean(BookService.class);
		String status = book.readLineContent("src/main/resources/bookdata.txt");
		System.out.println(status);
	}
}
