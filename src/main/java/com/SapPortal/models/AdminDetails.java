package com.SapPortal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "adminDetails")
public class AdminDetails {
	
	public AdminDetails(Long id, String department, String position, Long userId) {
		super();
		this.id = id;
		this.department = department;
		this.position = position;
		this.userId = userId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "userId")
	private Long userId;

	public AdminDetails( String department, String position,Long userId) {
		super();
		this.department = department;
		this.position = position;
		this.userId=userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public AdminDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
