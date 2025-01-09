package i.vk.exp;

import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("serial")
public class CourseNotFoundException extends RuntimeException {
	
	public CourseNotFoundException() {

	}

	public CourseNotFoundException(String msg) {
		super(msg);
	}
}
