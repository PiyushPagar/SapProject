package com.SapPortal.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SapPortal.dto.SendNotificationDto;
import com.SapPortal.models.ApplicationForm;
import com.SapPortal.models.NotificationLog;
import com.SapPortal.models.Notifications;
import com.SapPortal.models.User;
import com.SapPortal.repository.ApplicationFormRepository;
import com.SapPortal.repository.NotificationLogRepository;
import com.SapPortal.repository.NotificationsRepository;
import com.SapPortal.repository.UserRepository;
import com.SapPortal.security.services.EmailSenderService;
import com.SapPortal.util.ConstantUtil;
import com.SapPortal.util.DateUtil;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class NotifiacationController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ApplicationFormRepository applicationFormRepository;
	
	@Autowired
	private NotificationsRepository notificationsRepository;
	
	@Autowired
	NotificationLogRepository notificationLogRepository;
	
	@Autowired
	EmailSenderService emailSenderService;

	@PostMapping("/addNotification")
	public ResponseEntity<Notifications> saveNotification(@Validated @RequestBody Notifications notificationData) {
		LocalDate date = java.time.LocalDate.now();
		Notifications notification = new Notifications();
		notification.setCode(notificationData.getCode());
		notification.setName(notificationData.getName());
		notification.setTitle(notificationData.getTitle());
		notification.setBody(notificationData.getBody());
		notification.setStatus(notificationData.getStatus());
		notification.setUserId(notificationData.getUserId());
		notification.setFile(notificationData.getFile());
		notification.setCreatedDateTime(date.toString());
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
		notification.setCreatedDateTime(new Date(0).toString());
		return new ResponseEntity<Notifications>(notificationsRepository.save(notification), HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteNotificationData/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> deleteProductById(@PathVariable("id") Long id) {
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

	@GetMapping("/getNotification")
	public ResponseEntity<List<Notifications>> getNotification() {
		List<Notifications> notificationList = (List<Notifications>) notificationsRepository.findAll();
		return new ResponseEntity<List<Notifications>>(notificationList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/sendNotification", method = RequestMethod.POST)
	public ResponseEntity<?> sendNotification(@RequestBody SendNotificationDto sendNotificationDto) {
		List<User> userList =new ArrayList<User>();
		List <ApplicationForm> applicationFormList=applicationFormRepository.findAllApplicationByStatus(sendNotificationDto.getStudentTypes());
		int modulesize=sendNotificationDto.getModules().size();
		int departmentsize=sendNotificationDto.getDepartment().size();
		for(ApplicationForm applicationForm :applicationFormList) 
		{
			for(int i=0;i<modulesize;i++) 
			{
				if(applicationForm.getSapModule().equalsIgnoreCase(sendNotificationDto.getModules().get(i))) 
				{
					for(int j=0;j<departmentsize;j++) 
					{
						if(applicationForm.getBranch().equalsIgnoreCase(sendNotificationDto.getDepartment().get(j))) 
						{
							User users = userRepository.findById(applicationForm.getUserId()).get();
							userList.add(users);
						}
				
					}
			    }
		    }
		}
		List<Integer> userIds=new ArrayList<Integer>();
		for(User user :userList) {
			NotificationLog notificationLog = new NotificationLog();
			notificationLog.setCreatedDateTime(DateUtil.currentformatDateTime(ConstantUtil.DateFormat));
			notificationLog.setNotificationId(sendNotificationDto.getNotificationId());
			notificationLog.setUserId(user.getId());
			notificationLog.setView_status(false);
			notificationLogRepository.save(notificationLog);
			Integer UserId= emailSenderService.sendEmailForNotification(notificationLog);
			userIds.add(UserId);
		}
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	

}
