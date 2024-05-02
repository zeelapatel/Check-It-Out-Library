package edu.neu.csye6200.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.neu.csye6200.entity.Admin;

@Service
public interface AdminRepo extends JpaRepository<Admin, Long> {

	Admin findByAdminemail(String email);
}
