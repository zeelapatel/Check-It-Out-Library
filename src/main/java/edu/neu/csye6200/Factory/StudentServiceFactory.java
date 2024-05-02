package edu.neu.csye6200.Factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.csye6200.entity.Student;
import edu.neu.csye6200.services.StudentService;

// implemented lazy factory method
@Component
public class StudentServiceFactory {
	@Autowired
	private final StudentService studentService;

	private static StudentServiceFactory instance;

	private StudentServiceFactory(StudentService ss) {
		this.studentService = ss;
	}

	public static StudentServiceFactory getInstance(StudentService ss) {
		if (instance == null) {
			instance = new StudentServiceFactory(ss);
		}
		return instance;
	}

	public Student createStudentObj(String email, String password) {
		try {
			Student s = studentService.verifyCredentials(email, password);
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}
}


