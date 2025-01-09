package i.vk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import i.vk.service.AdminUserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		AdminUserService service = context.getBean(AdminUserService.class);
//		service.saveAdminRecord();  // C
//		service.readRecordById();   // R
//		service.readAllRecords();
//		service.updateRecordById(); // U
		service.deleteRecordById(); // D
		
	}

}
