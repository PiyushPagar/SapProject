package com.SapPortal.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.SapPortal.models.ApplicationQueryByAdmin;
import com.SapPortal.models.NotificationLog;
import com.SapPortal.models.Notifications;
import com.SapPortal.models.User;
import com.SapPortal.repository.NotificationsRepository;
import com.SapPortal.repository.UserRepository;
import com.SapPortal.util.ConstantUtil;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private NotificationsRepository notificationsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public String sendEmail(String email,String subject,String body)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(ConstantUtil.OtpSenderemail);
		int randompin =(int) (Math.random()*9000)+1000;
		message.setTo(email);
		message.setText(body+randompin);
		message.setSubject(subject);
		mailSender.send(message);
		System.out.println("Otp Send Successful"+randompin);
		return ""+randompin;
	
	}

	public String sendEmailForQuery(String email, ApplicationQueryByAdmin applicationQueryByAdmin) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(ConstantUtil.OtpSenderemail);
		message.setTo(email);
		message.setText("You have Got Query Of Your Application from Of SAP Please Visit on the Portal and Provide The Requried or Contact with Admin"
				+ "/n Query Is ="+applicationQueryByAdmin.getQueryTitle()+"Description"+applicationQueryByAdmin.getQueryDesc()
				+"Contact To  = "  +applicationQueryByAdmin.getReachoutPersonName() +applicationQueryByAdmin.getReachoutPersonContactNumber()+" /n "
				+ applicationQueryByAdmin.getReachoutPersonDetails());
		message.setSubject(ConstantUtil.QuerySubject);
		mailSender.send(message);
		System.out.println("Email of Query send successfully");
		return "Email of Query send successfully";
	}
	
	public Integer sendEmailForNotification(NotificationLog notificationLog) {
		SimpleMailMessage message = new SimpleMailMessage();
		User user = userRepository.findById(notificationLog.getUserId()).get();
		Notifications notifications =notificationsRepository.findById(notificationLog.getNotificationId());
		message.setFrom(ConstantUtil.OtpSenderemail);
		message.setTo(user.getEmail());
		message.setText( " Notification Title  =   "+notifications.getTitle()+"   \n\n Notification Name  =   "+notifications.getName()+"   \n\n Notification Body  =   "+notifications.getBody() );
		message.setSubject(ConstantUtil.NotificationSubject + notifications.getTitle());
		mailSender.send(message);
		System.out.println("Email of Query send successfully");
		return user.getId().intValue();
	}

}
