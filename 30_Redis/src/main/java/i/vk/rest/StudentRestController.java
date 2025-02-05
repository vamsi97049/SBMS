package i.vk.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import i.vk.entity.Student;
import i.vk.repo.StudentRepository;

@RestController
public class StudentRestController {
	
	@Autowired
	private StudentRepository srepo;
	
	@GetMapping("/students")
	public Iterable<Student> getAllStudents(){
		return srepo.findAll();
	}
	
	@PostMapping("/student")	
	public String addStudent(@RequestBody Student student) {
		srepo.save(student);
		return "Student Saved";
	}

}