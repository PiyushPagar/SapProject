package com.SapPortal.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Application_form")
public class ApplicationForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int StudentId;
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
//	public ApplicationForm(int studentId,String email, String name, String collegeEmail, String sapModule, String contactNumber,
//			String passoutYear, String branch, String specialization, String studentType, String adhaarCard,
//			String uploadImage) {
//		super();
//		StudentId = studentId;
//		this.email = email;
//		this.name = name;
//		this.collegeEmail = collegeEmail;
//		this.sapModule = sapModule;
//		this.contactNumber = contactNumber;
//		this.passoutYear = passoutYear;
//		this.branch = branch;
//		this.specialization = specialization;
//		this.studentType = studentType;
//		this.adhaarCard = adhaarCard;
//		this.uploadImage = uploadImage;
//	}
//	
//	public ApplicationForm() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
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
