package edu.neu.csye6200.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.neu.csye6200.entity.Admin;
import edu.neu.csye6200.repo.AdminRepo;

@Service
public class AdminService {

	@Autowired
	private AdminRepo adminrepo;

	public Admin addAdmin(Admin admin) {
		return adminrepo.save(admin);

	}

	public Admin verifyCredentials(String adminemail, String password) {
		Admin user = adminrepo.findByAdminemail(adminemail);
		if (user != null && user.getPassword().equals(password)) {
			// Return the Student object with id and name
			return user;
		}
		return null; // Credentials are invalid
	}

}
