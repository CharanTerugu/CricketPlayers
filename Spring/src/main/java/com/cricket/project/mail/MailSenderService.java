package com.cricket.project.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	public void sendsimpleEmail(String toEmail,String body,String subject)
	{
	 SimpleMailMessage message=new SimpleMailMessage();
	 message.setFrom("confirmationdeatails.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
	}
}
