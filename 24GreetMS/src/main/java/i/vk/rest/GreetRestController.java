package i.vk.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import i.vk.feigns.WelcomeApi;

@RestController
public class GreetRestController {
	@Autowired
	private WelcomeApi welcomeApi;
	
	@GetMapping("/greet")
	public String invokeGreet() {
		String msg1 = welcomeApi.invokeWelcome();
		String msg = "Hello Vamsi krishna "+msg1;
		return msg;
	}
}
