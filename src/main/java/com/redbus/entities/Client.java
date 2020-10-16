package com.redbus.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	private String email;
	
	private String phoneNo;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
