package i.vk.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetUser {
	@GetMapping("/greetuser")
	public String greetUser() {
		return "<h1 style='color:darkblue;'>Welcome to VK-Virtual Services ( Andhra Pradesh )</h1>";
	}
	@GetMapping("/home")
	public String home() {
		String name = null;
		int length = name.length();
		return "Length is : "+length;
	}
}
