package com.SapPortal.dto;

import java.util.List;

public class SendNotificationDto{
	
	Long notificationId;
	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	List<String> modules;
	
	List<String> department;
	
	List<String> studentTypes;
	
	public List<String> getModules() {
		return modules;
	}

	public void setModules(List<String> modules) {
		this.modules = modules;
	}

	public List<String> getDepartment() {
		return department;
	}

	public void setDepartment(List<String> department) {
		this.department = department;
	}

	public List<String> getStudentTypes() {
		return studentTypes;
	}

	public void setStudentTypes(List<String> studentTypes) {
		this.studentTypes = studentTypes;
	}


	
	

}
