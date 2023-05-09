package com.SapPortal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Application_Query_By_Admin")
public class ApplicationQueryByAdmin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int applicationId;
	private int userId;
	private String queryTitle;
	private String queryDesc;
	private String contactDetails;
	private String reachoutPersonName;
	private String reachoutPersonDetails;
	private String reachoutPersonContactNumber;
	private String isActive;
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getQueryTitle() {
		return queryTitle;
	}
	public void setQueryTitle(String queryTitle) {
		this.queryTitle = queryTitle;
	}
	public String getQueryDesc() {
		return queryDesc;
	}
	public void setQueryDesc(String queryDesc) {
		this.queryDesc = queryDesc;
	}
	public String getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	public String getReachoutPersonName() {
		return reachoutPersonName;
	}
	public void setReachoutPersonName(String reachoutPersonName) {
		this.reachoutPersonName = reachoutPersonName;
	}
	public String getReachoutPersonDetails() {
		return reachoutPersonDetails;
	}
	public void setReachoutPersonDetails(String reachoutPersonDetails) {
		this.reachoutPersonDetails = reachoutPersonDetails;
	}
	public String getReachoutPersonContactNumber() {
		return reachoutPersonContactNumber;
	}
	public void setReachoutPersonContactNumber(String reachoutPersonContactNumber) {
		this.reachoutPersonContactNumber = reachoutPersonContactNumber;
	}
	

}
