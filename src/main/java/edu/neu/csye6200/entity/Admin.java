package edu.neu.csye6200.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin_Table")
public class Admin {
	
	@Id
	@Column(name = "Admin_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminid;
	
	@Column(name = "Admin_first_name", length = 225)
    private String adminfirstName;
	
	@Column(name = "Admin_last_name", length = 225)
    private String adminlastName;
    
    @Column(name = "Admin_email", length = 225,unique = true)
    private String adminemail;

    @Column(name = "password", length = 225)
    private String Password;

	public Long getAdminid() {
		return adminid;
	}

	public void setAdminid(Long adminid) {
		this.adminid = adminid;
	}

	public String getAdminfirstName() {
		return adminfirstName;
	}

	public void setAdminfirstName(String adminfirstName) {
		this.adminfirstName = adminfirstName;
	}

	public String getAdminlastName() {
		return adminlastName;
	}

	public void setAdminlastName(String adminlastName) {
		this.adminlastName = adminlastName;
	}

	public String getAdminemail() {
		return adminemail;
	}

	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
    
    

}
