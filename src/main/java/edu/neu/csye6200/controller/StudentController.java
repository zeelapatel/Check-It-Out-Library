package edu.neu.csye6200.controller;

import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.csye6200.Factory.BooksServiceFactory;
import edu.neu.csye6200.Factory.StudentServiceFactory;
import edu.neu.csye6200.entity.AssignBooks;
import edu.neu.csye6200.entity.Student;
import edu.neu.csye6200.services.BooksService;
import edu.neu.csye6200.services.StudentService;

@RestController
@CrossOrigin
public class StudentController {

	private final StudentService service;

	private final BooksService booksService;

	public StudentController(StudentService service, BooksService booksService) {
		this.service = service;
		this.booksService = booksService;
	}

	private long studentid;

	@PostMapping("/addstudent")
	public Student addstudent(@RequestBody Student student) {
		return service.saveStudent(student);

	}

	@PostMapping("/studentLogin")
	public ResponseEntity<Map<String, String>> verifyCredentials(@RequestBody Map<String, String> credentials) {
		String email = credentials.get("email");
		String password = credentials.get("password");

		Student student = StudentServiceFactory.getInstance(service).createStudentObj(email, password);

		if (student != null) {
			// Capture the id and name
			Long sid = student.getStudid();
			studentid = sid;
			String name = student.getFirstName() + " " + student.getLastName();

			// Create a response message
			Map<String, String> response = new HashMap<>();
			response.put("status", "success");
			response.put("message", "Credentials are valid!");
			response.put("studentId", sid.toString());
			response.put("name", name);

			System.out.println("Credentials are valid!");
			// Return the response with a status code of 200 (OK)
			return ResponseEntity.ok(response);
		} else {
			// Return an error response with a status code of 401 (Unauthorized)
			Map<String, String> response = new HashMap<>();
			response.put("status", "error");
			response.put("message", "Invalid credentials!");

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}
	}

	@GetMapping("/search/studentbooks")
	public ResponseEntity<List<AssignBooks>> getBooksByStudentId() {
		// Use the service method to get the list of books by student ID
		List<AssignBooks> books = BooksServiceFactory.getInstance(booksService).getBook(studentid);

		if (!books.isEmpty()) {
			// Return the list of books with a status code of 200 (OK)
			return ResponseEntity.ok(books);
		} else {
			// Return a not found response with a status code of 404
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/studentProfile")
	public ResponseEntity<Student> getStudentByIdFromVariable() {
		// Assuming you have the student ID stored in a variable named 'studentId'
		long studentId = studentid; // Replace 'yourStudentIdVariable' with your actual variable

		Optional<Student> optionalStudent = service.getStudentById(studentId);

		return optionalStudent.map(student -> new ResponseEntity<>(student, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
