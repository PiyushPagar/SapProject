package com.SapPortal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sap_Credentials_Datails")
public class SapCredentialsDatails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "username")
	private String sapUsername;
	
	@Column(name = "password")
	private String sapPassword;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSapUsername() {
		return sapUsername;
	}

	public void setSapUsername(String sapUsername) {
		this.sapUsername = sapUsername;
	}

	public String getSapPassword() {
		return sapPassword;
	}

	public void setSapPassword(String sapPassword) {
		this.sapPassword = sapPassword;
	}

	
	

}
