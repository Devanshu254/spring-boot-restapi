package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Ramesh","Sharma"));
		students.add(new Student(2, "Umesh", "Yadav"));
		students.add(new Student(3, "Rohit", "Sharma"));
		students.add(new Student(4, "Sanjaya", "Singhania"));
		return students;
	}
	
	// Spring Boot REST API application with path variable.
	// {id} - URI template variable
	// http://localhost:8080/students/1
	@GetMapping("students/{id}")
	public Student studentPathVariable(@PathVariable("id") int Studentid) {
		return new Student(Studentid, "Ramesh","Sharma");
	}
}
