package edu.neu.csye6200.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.csye6200.entity.Student;
import edu.neu.csye6200.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentrepo;
	
	public Student saveStudent(Student student) {
		return studentrepo.save(student);
		
	}
	
	public Student verifyCredentials(String email, String password) {
        Student user = studentrepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            // Return the Student object with id and name
            return user;
        }
        return null; // Credentials are invalid
    }

	public Optional<Student> getStudentById(long studentId) {
		
		return studentrepo.findById(studentId);
	}
	
	
}
