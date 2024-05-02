package edu.neu.csye6200.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import edu.neu.csye6200.Factory.AdminserviceFactory;
import edu.neu.csye6200.entity.Admin;
import edu.neu.csye6200.services.AdminService;

@RestController
@CrossOrigin

@RequestMapping("/Admin")
public class AdminController {

	// implementing inner class and Factory method
	static class AdminserviceFactory {

		@Autowired
		private final AdminService adminService;

		private static AdminserviceFactory instance;

		private AdminserviceFactory(AdminService as) {
			this.adminService = as;
		}

		public static AdminserviceFactory getInstance(AdminService as) {
			if (instance == null) {
				instance = new AdminserviceFactory(as);
			}
			return instance;
		}

		public Admin createAdminObj(String email, String password) {
			try {
				Admin admin = adminService.verifyCredentials(email, password);
				return admin;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	private final AdminService adminservice;

	public AdminController(AdminService adminService) {
		this.adminservice = adminService;
	}

	long adminid;

	@PostMapping("/addadmin")
	public Admin addadmin(@RequestBody Admin admin) {
		return adminservice.addAdmin(admin);
	}

	@PostMapping("/adminverify")
	public ResponseEntity<Map<String, String>> adminLogin(@RequestBody Map<String, String> credentials) {
		String email = credentials.get("adminemail");
		String password = credentials.get("password");

		Admin admin = AdminserviceFactory.getInstance(adminservice).createAdminObj(email, password);

		if (admin != null) {
			// Capture the id and name
			Long aid = admin.getAdminid();
			adminid = aid;
			String name = admin.getAdminfirstName() + " " + admin.getAdminlastName();

			// Create a response message
			Map<String, String> response = new HashMap<>();
			response.put("status", "success");
			response.put("message", "Credentials are valid!");
			response.put("adminId", aid.toString());
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

}
