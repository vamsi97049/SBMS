package i.vk.configclasses;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetUserConfigClass {
	@GetMapping("/welcome")
	public ModelAndView greetUser() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","Welcome to VK52 Virtual Services");
		mav.setViewName("index");	
		return mav;
	}
}
