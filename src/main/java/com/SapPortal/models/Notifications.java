package com.SapPortal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Notifiation_Table")
public class Notifications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notificationId;

	private String createdDateTime;

	private String notificationName;

	private String notificationData;

	private String notificationmodule;

	private String notificationLink;

	private String notificationImportantdates;

	private String file;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getNotificationName() {
		return notificationName;
	}

	public void setNotificationName(String notificationName) {
		this.notificationName = notificationName;
	}

	public String getNotificationmodule() {
		return notificationmodule;
	}

	public void setNotificationmodule(String notificationmodule) {
		this.notificationmodule = notificationmodule;
	}

	public String getNotificationLink() {
		return notificationLink;
	}

	public void setNotificationLink(String notificationLink) {
		this.notificationLink = notificationLink;
	}

	public String getNotificationImportantdates() {
		return notificationImportantdates;
	}

	public void setNotificationImportantdates(String notificationImportantdates) {
		this.notificationImportantdates = notificationImportantdates;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getNotificationData() {
		return notificationData;
	}

	public void setNotificationData(String notificationData) {
		this.notificationData = notificationData;
	}

	public Notifications(int notificationId, String createdDateTime, String notificationName, String notificationmodule,
			String notificationLink, String notificationImportantdates, String file) {
		super();
		this.notificationId = notificationId;
		this.createdDateTime = createdDateTime;
		this.notificationName = notificationName;
		this.notificationmodule = notificationmodule;
		this.notificationLink = notificationLink;
		this.notificationImportantdates = notificationImportantdates;
		this.file = file;
	}

	public Notifications() {
		super();
		// TODO Auto-generated constructor stub
	}

}
