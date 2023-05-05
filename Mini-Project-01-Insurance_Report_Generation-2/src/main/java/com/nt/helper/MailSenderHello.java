 package com.nt.helper;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSenderHello {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendMail(String to,String subject,String body) {
		try {
		MimeMessage msg=mailSender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(msg);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body,true);
		
		mailSender.send(msg);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
