package com.SapPortal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SapPortal.models.ApplicationForm;
import com.SapPortal.models.Notifications;
import com.SapPortal.repository.NotificationsRepository;
import com.SapPortal.security.services.NotificationService;

@RestController
public class NotifiacationController {
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	NotificationsRepository notificationTableRepository;
	
	@DeleteMapping("/deleteNotification/{notificationId}")
	private void deleteBook(@PathVariable("notificationId") int notificationId) {
		notificationService.delete(notificationId);
	}
	
	@GetMapping("/getallNotifiaction")
	private Iterable<Notifications> getAllNotification() {
		return notificationTableRepository.findAll();
	}
	
	@PostMapping("/notifications")
	private int saveBook(@RequestBody Notifications Notifications) {
		notificationService.saveOrUpdate(Notifications);
		return Notifications.getNotificationId();
	}
	

}
