package com.SapPortal.controllers;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.SapPortal.models.Notifications;
import com.SapPortal.repository.NotificationsRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class NotifiacationController {

	@Autowired
	private NotificationsRepository notificationsRepository;

	@PostMapping("/addNotification")
	public ResponseEntity<Notifications> saveNotification(@Validated @RequestBody Notifications notificationData) {
		Notifications notification = new Notifications();
		notification.setCode(notificationData.getCode());
		notification.setName(notificationData.getName());
		notification.setTitle(notificationData.getTitle());
		notification.setBody(notificationData.getBody());
		notification.setStatus(notificationData.getStatus());
		notification.setUserId(notificationData.getUserId());
		notification.setFile(notificationData.getFile());
		notification.setNotificationmodule(notificationData.getNotificationmodule());
		notification.setCreatedDateTime(new Date(0).toString());
		return new ResponseEntity<Notifications>(notificationsRepository.save(notification), HttpStatus.OK);
	}

	@PutMapping("/updateNotification/{id}")
	public ResponseEntity<Notifications> updateNotification(@Validated @RequestBody Notifications notificationData,
			@PathVariable("id") Long id) {
		Notifications notification = notificationsRepository.findById(id);
		notification.setCode(notificationData.getCode());
		notification.setName(notificationData.getName());
		notification.setTitle(notificationData.getTitle());
		notification.setBody(notificationData.getBody());
		notification.setStatus(notificationData.getStatus());
		notification.setUserId(notificationData.getUserId());
		notification.setFile(notificationData.getFile());
		notification.setNotificationmodule(notificationData.getNotificationmodule());
		notification.setCreatedDateTime(new Date(0).toString());
		return new ResponseEntity<Notifications>(notificationsRepository.save(notification), HttpStatus.OK);
	}

	@RequestMapping(value = "deleteNotificationData/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> deleteProductById(@PathVariable("NotificationDataId") Long id) {
		Notifications notificationData = notificationsRepository.findById(id);
		if (notificationData != null) {
			notificationData.setStatus("inactive");
			notificationsRepository.save(notificationData);
			return new ResponseEntity<>(notificationData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("notificationData Not found for this notificationDataId",
					HttpStatus.FAILED_DEPENDENCY);
		}
	}

}
