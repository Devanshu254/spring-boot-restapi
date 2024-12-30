package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	// http://localhost:8080/students/1/Ramesh/Sharma
	@GetMapping("students/{id}/{first-name}/{last-name}")
	public Student studentPathVariable(@PathVariable("id") int studentId,
			@PathVariable("first-name") String firstName,
			@PathVariable("last-name") String lastName) {
		return new Student(studentId, firstName, lastName);
	}
	
	// Spring Boot REST API to handle multiple query parameters.
	// http://localhost:8080/students/query?id=1&firsName=Devanshu&lastName=Jha
	@GetMapping("students/query")
	public Student studentRequestVariable(@RequestParam int id,@RequestParam String firstName,@RequestParam String lastName) {
		return new Student(id, firstName, lastName);
	}
	
	// Spring Boot REST API that Handles HTTP PUT Request - updating the existing resource.
	@PutMapping("student/{id}/update")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirsName());
		System.out.println(student.getLastName());
		return student;
	}
	
}