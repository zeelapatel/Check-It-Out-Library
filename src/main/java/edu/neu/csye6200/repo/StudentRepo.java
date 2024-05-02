package edu.neu.csye6200.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.neu.csye6200.entity.Student;


public interface StudentRepo extends JpaRepository <Student, Long>{
	
	Student findByEmail(String email);

}
