package com.SapPortal.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SapPortal.models.ApplicationForm;
import com.SapPortal.models.Notifications;
import com.SapPortal.repository.NotificationsRepository;

@Service
public class NotificationService {
	
	@Autowired
	NotificationsRepository notificationTableRepository;
	
	public List<Notifications> getAllNotifications()   
	{
		return (List<Notifications>) notificationTableRepository.findAll();
	}
	
	
//	public List<ApplicationForm> getAllApplicationForm()   
//	{
//		List<ApplicationForm> applicationForm = new ArrayList<ApplicationForm>();
//		applicationFormRepository.findAll().forEach(applicationForm1 -> applicationForm.add(applicationForm1));
//		return applicationForm;
//	}
	
	
	public Notifications getNotificationsById(int notificationId)   
	{  
	return notificationTableRepository.findById(notificationId).get();  
	}  
//	
//	public ApplicationForm getApplicationFormByuserId(int userId)   
//	{  
//	return notificationTableRepository.findById(userId).get();  
//	}

	public void saveOrUpdate(Notifications notifications)   
	{  
		notificationTableRepository.save(notifications);  
	}  
	public void delete(int notificationId)   
	{  
		notificationTableRepository.deleteById(notificationId);  
	}  	 
	public void update(Notifications notifications, int notificationId)   
	{  
		notificationTableRepository.save(notifications);  
	}  
  

}
