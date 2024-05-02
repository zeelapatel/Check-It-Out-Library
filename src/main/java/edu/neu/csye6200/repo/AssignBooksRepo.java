package edu.neu.csye6200.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.neu.csye6200.entity.AssignBooks;

public interface AssignBooksRepo  extends JpaRepository<AssignBooks, Long> {

	List<AssignBooks> findByStudentId(Long studentId);
}
