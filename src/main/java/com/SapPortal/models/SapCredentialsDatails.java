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
	private Long sapUsername;
	
	@Column(name = "password")
	private Long sapPassword;

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

	public Long getSapUsername() {
		return sapUsername;
	}

	public void setSapUsername(Long sapUsername) {
		this.sapUsername = sapUsername;
	}

	public Long getSapPassword() {
		return sapPassword;
	}

	public void setSapPassword(Long sapPassword) {
		this.sapPassword = sapPassword;
	}
	
	

}
