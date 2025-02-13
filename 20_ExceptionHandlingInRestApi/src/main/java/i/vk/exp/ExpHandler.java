package i.vk.exp;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import i.vk.inders.ExpPacket;

@Service
@RestControllerAdvice
public class ExpHandler {
	
	@ExceptionHandler(value = CourseNotFoundException.class)
	public ResponseEntity<ExpPacket> CourseNotFoundException(CourseNotFoundException e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExpPacket("DevException:90001",e.getMessage(),LocalDateTime.now()));
	}
	
	@ExceptionHandler(value = Exception.class)
	public ExpPacket handleUnknownException(Exception e) {
		return new ExpPacket("ApplicatinException:60001",e.getMessage(),LocalDateTime.now());
	}
	
}
