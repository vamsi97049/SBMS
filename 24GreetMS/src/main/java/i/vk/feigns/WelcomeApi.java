package i.vk.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="23WelcomeMS")
public interface WelcomeApi {
	@GetMapping("/welcome")
	public String invokeWelcome();
}
