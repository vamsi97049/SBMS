package i.vk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import i.vk.service.EmployeeAshokITService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeAshokITService service = context.getBean(EmployeeAshokITService.class);
//		service.saveEmployee();
//		service.getRecord();
//		service.getAllRecords();
		service.updateRecordById();
//		service.deleteRecordById();
//		service.saveAllRecords();
		
	}

}
