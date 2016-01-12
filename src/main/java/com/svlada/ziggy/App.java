package com.svlada.ziggy;

import org.apache.log4j.Logger;

import com.svlada.ziggy.email.EmailAddress;
import com.svlada.ziggy.mailsender.AmazonMailSender;
import com.svlada.ziggy.mailsender.AmazonMailSenderFactory;

public class App {
	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(App.class);
		
		AmazonMailSender mailSender = AmazonMailSenderFactory.of().create();
		
		Email email = new Email.Builder().from(EmailAddress.of("svlada@gmail.com")).to(EmailAddress.of("test@gmail.com")).build();
		
		mailSender.send(email);
	}
}
