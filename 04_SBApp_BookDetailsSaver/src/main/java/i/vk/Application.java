package i.vk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import i.vk.dto.BookDTO;
import i.vk.service.BookService;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(Application.class, args);
		BookService service = ctxt.getBean(BookService.class);
		BookDTO book = new BookDTO(1001,"Spring Boot and Micro Services","Mr.Ashok kumar Bollepalli",1500.00);
		String result = service.saveBookService(book);
		System.out.println(result);
	}
}
