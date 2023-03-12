package com.SapPortal.dto;

public class AdminUserDto {
	
	long id;
	String email;
	String name;
	String mobileNumber;
	String status;
	String department;
	String position;
	
	
	
	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public AdminUserDto() {
		super();
	}


	public AdminUserDto(long id, String email, String name, String mobileNumber, String status, String department,String position) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.status = status;
		this.department = department;
		this.position=position;
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
