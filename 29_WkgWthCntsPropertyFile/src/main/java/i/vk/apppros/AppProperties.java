package i.vk.apppros;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	HashMap<String,String> alertMsgs = new HashMap<>();
}
