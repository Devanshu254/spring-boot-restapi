package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springboot.bean.Student;

// Rest controller is a combination of @Controller and @Response body. Just that. 
@RestController
public class StudentController {
	@GetMapping("student")
	public Student getStudent() {
		Student student = new Student(1,"Ramesh","Fadetare");
		return student;
	}
}
