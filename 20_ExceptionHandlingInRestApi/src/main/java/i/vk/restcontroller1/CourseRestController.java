package i.vk.restcontroller1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import i.vk.exp.CourseNotFoundException;
import lombok.SneakyThrows;

@RestController
public class CourseRestController {
	@GetMapping("/courses")
	@SneakyThrows
	public ResponseEntity<String> courseFinder(@RequestParam("course") String course) {
		if("SBMS".equals(course)) {
			return ResponseEntity.status(HttpStatus.OK).body("SBMS batch is going to start on 10th Jan 2025 by Mr.Ashok");
		}
		else if("JRTP".equals(course)) {
			return ResponseEntity.status(HttpStatus.OK).body("JRTP batch is going to start on 25th Jan 2025 by Mr.Ashok");
		}else {
			throw new CourseNotFoundException("Course Not Found");
		}
	}
}
