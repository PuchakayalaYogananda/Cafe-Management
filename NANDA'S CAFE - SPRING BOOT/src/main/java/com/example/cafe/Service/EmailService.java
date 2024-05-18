package com.example.cafe.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Async
	public void sendEmail(String toEmail, String username, String password) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(toEmail);
		mailMessage.setSubject("Welcome to NANDAS Cafe!");
		mailMessage.setFrom("puchakayalayogananda22@gmail.com");

		String emailContent = "Dear " + username + ",\n\n";
		emailContent += "Thank you for registering at Our Cafe!\n\n";
		emailContent += "Your username: " + username + "\n";
		emailContent += "Your password: " + password + "\n\n";
		emailContent += "We're excited to have you on board.\n\n";
		emailContent += "Best regards,\n";
		emailContent += "The Our Cafe Team";

		mailMessage.setText(emailContent);

		javaMailSender.send(mailMessage);
	}
}
