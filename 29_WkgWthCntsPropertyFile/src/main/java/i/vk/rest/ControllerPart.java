package i.vk.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import i.vk.apppros.AppProperties;

@RestController
public class ControllerPart {
	@Autowired
	AppProperties appProps;
	
	
	@GetMapping("/greet")
	public String greetUser() {
		HashMap<String,String> alertMsgs = appProps.getAlertMsgs();
		return "<h1 style='color:darkgreen;'>Greetings for the day</h1>"+alertMsgs.get("login_success");
	}
	@GetMapping("/welcome")
	public String welcomeUser() {
		HashMap<String,String> alertMsgs = appProps.getAlertMsgs();
		return "<h1 style='color:darkgreen;'>Welcome to Vk-Virtual Services</h1>"+alertMsgs.get("action_processed");
	}
}
