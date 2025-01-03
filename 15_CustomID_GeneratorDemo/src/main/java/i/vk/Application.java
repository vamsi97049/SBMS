package i.vk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import i.vk.service.OrderService;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        OrderService service = context.getBean(OrderService.class);
        service.insertOrder();
    }    
}
