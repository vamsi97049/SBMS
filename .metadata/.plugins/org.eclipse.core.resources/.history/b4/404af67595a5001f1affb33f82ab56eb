package i.vk52.myapps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import i.vk52.beans.BookService;

public class App {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Beans.xml");
//		BookService service = ctxt.getBean(BookService.class);
//		service.fileReader();
		BookService service = ctxt.getBean(BookService.class);
		service.fileReader();
//		service.export2CSV();
//		service.export2ExcelFile();
		ConfigurableApplicationContext cctxt = (ConfigurableApplicationContext)ctxt;
		cctxt.close();
	}
}
