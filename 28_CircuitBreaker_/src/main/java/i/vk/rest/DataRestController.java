package i.vk.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@RestController
public class DataRestController {
	
	@SuppressWarnings("null")
	@GetMapping("/data")
	@CircuitBreaker(fallbackMethod = "getDataFromDB", name="vkr1")
	public String getDataFromRedis() {
		System.out.println("Redis");
		Integer result = 19/0;
		return "Data Fetching Done [Source::Redis] ";
	}
	
	public String getDataFromDB(Throwable t) {
		System.out.println("Database");
		return "Data Fetching Done [Source::Database]";
	}
	
	
	
}
