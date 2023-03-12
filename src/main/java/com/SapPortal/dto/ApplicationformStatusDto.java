package com.SapPortal.dto;

public class ApplicationformStatusDto {
	
	long userId;
	long applicationformId;
	String applicationformStatus;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getApplicationformId() {
		return applicationformId;
	}
	public void setApplicationformId(long applicationformId) {
		this.applicationformId = applicationformId;
	}
	public String getApplicationformStatus() {
		return applicationformStatus;
	}
	public void setApplicationformStatus(String applicationformStatus) {
		this.applicationformStatus = applicationformStatus;
	}

}
