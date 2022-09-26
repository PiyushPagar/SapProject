package com.SapPortal.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.SapPortal.util.ConstantUtil;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
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
		return "Otp Send Successfully and Otp is "+randompin;
	
	}

}
