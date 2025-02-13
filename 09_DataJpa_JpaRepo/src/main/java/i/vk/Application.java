package i.vk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import i.vk.service.PersonService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		PersonService bean = context.getBean(PersonService.class);
//		bean.savePerson();
//		bean.getPersons();
//		bean.getPersonsByPagination();
		bean.getPersonsByQBE("Female", null);
	}
	

}
