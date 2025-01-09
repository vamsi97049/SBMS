package i.vk.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRC {
	
	@Autowired
	private Environment env;
	
	@GetMapping("/welcome")
	public String invokeWelcome() {
		String port = env.getProperty("server.port");
		return "Welcome to Vk Virtual Services : "+"( "+port+" )";
	}
}
