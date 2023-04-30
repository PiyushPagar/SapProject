package com.SapPortal.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "Application_form")
public class ApplicationForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String email;
	private String name;
	private String collegeEmail;
	private String sapModule;
	private String contactNumber;
	private String passoutYear;
	private String branch;
	private String specialization;
	private String studentType;
	private String adhaarCard;
	private String uploadImage;
	private String applicationFromStatus;
	private Long userId;
	private Boolean isQueryInApplication;
	public Boolean getIsQueryInApplication() {
		return isQueryInApplication;
	}

	public void setIsQueryInApplication(Boolean isQueryInApplication) {
		this.isQueryInApplication = isQueryInApplication;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getApplicationFromStatus() {
		return applicationFromStatus;
	}

	public void setApplicationFromStatus(String applicationFromStatus) {
		this.applicationFromStatus = applicationFromStatus;
	}

	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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
	public String getCollegeEmail() {
		return collegeEmail;
	}
	public void setCollegeEmail(String collegeEmail) {
		this.collegeEmail = collegeEmail;
	}
	public String getSapModule() {
		return sapModule;
	}
	public void setSapModule(String sapModule) {
		this.sapModule = sapModule;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassoutYear() {
		return passoutYear;
	}
	public void setPassoutYear(String passoutYear) {
		this.passoutYear = passoutYear;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getStudentType() {
		return studentType;
	}
	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}
	public String getAdhaarCard() {
		return adhaarCard;
	}
	public void setAdhaarCard(String adhaarCard) {
		this.adhaarCard = adhaarCard;
	}
	public String getUploadImage() {
		return uploadImage;
	}
	public void setUploadImage(String uploadImage) {
		this.uploadImage = uploadImage;
	}


	
	

}
