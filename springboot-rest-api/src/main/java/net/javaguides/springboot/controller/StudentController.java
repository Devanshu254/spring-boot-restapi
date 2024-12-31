package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springboot.bean.Student;

// Rest controller is a combination of @Controller and @Response body. Just that. 
@RestController
@RequestMapping("students")
public class StudentController {
	@GetMapping("student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(1,"Ramesh","Fadetare");
//		return new ResponseEntity<>(student, HttpStatus.OK);
//		return ResponseEntity.ok(student);
		return ResponseEntity.ok().header("customer-header", "devanshu").body(student);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Ramesh","Sharma"));
		students.add(new Student(2, "Umesh", "Yadav"));
		students.add(new Student(3, "Rohit", "Sharma"));
		students.add(new Student(4, "Sanjaya", "Singhania"));
		return ResponseEntity.ok(students);
	}
	
	// Spring Boot REST API application with path variable.
	// {id} - URI template variable
	// http://localhost:8080/students/1/Ramesh/Sharma
	@GetMapping("{id}/{first-name}/{last-name}")
	public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
			@PathVariable("first-name") String firstName,
			@PathVariable("last-name") String lastName) {
		Student student = new Student(studentId, firstName, lastName);
		return ResponseEntity.ok(student);
	}
	
	// Spring Boot REST API to handle multiple query parameters.
	// http://localhost:8080/students/query?id=1&firsName=Devanshu&lastName=Jha
	@GetMapping("query")
	public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,@RequestParam String firstName,@RequestParam String lastName) {
		Student student = new Student(id, firstName, lastName);
		return ResponseEntity.ok(student);
	}
	
	@PostMapping("create")
	// @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirsName());
		System.out.println(student.getLastName());
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	// Spring Boot REST API that Handles HTTP PUT Request - updating the existing resource.
	@PutMapping("{id}/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirsName());
		System.out.println(student.getLastName());
		return ResponseEntity.ok(student);
	}
	
	// Spring Boot Rest API that handles HTTP Delete Request.
	@DeleteMapping("{id}/delete")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
		System.out.println(studentId);
		return ResponseEntity.ok("Student deleted successfully");
	}
	
}