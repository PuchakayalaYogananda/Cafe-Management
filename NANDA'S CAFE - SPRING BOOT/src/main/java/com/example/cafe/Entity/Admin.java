package com.example.cafe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public long adminId;
	
	public String adminName;
	
	public String adminPassword; 
	
	public String adminEmail; 
	
	public String adminContact; 
	
	
	public Admin() {
		
	}
	
	public Admin(long adminId,String adminName, String adminPassword, String adminEmail, String adminContact) {
		
		super();
		this.adminId = adminId;
		this.adminName = adminName; 
		this.adminPassword = adminPassword; 
		this.adminEmail = adminEmail; 
		this.adminContact = adminContact; 
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	
	

}
