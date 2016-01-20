package com.svlada.ziggy;

import org.apache.log4j.Logger;

import com.amazonaws.regions.Regions;
import com.svlada.ziggy.email.Content;
import com.svlada.ziggy.email.EmailAddress;
import com.svlada.ziggy.email.Subject;
import com.svlada.ziggy.mailsender.AmazonMailSender;
import com.svlada.ziggy.mailsender.AmazonMailSenderFactory;

public class App {
	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(App.class);
		
		AmazonMailSender mailSender = AmazonMailSenderFactory.of().create(Regions.US_EAST_1);
		
		Email email = Email.builder().from(EmailAddress.of("Microservices Weekly <mw@microservicesweekly.com>"))
				.to(EmailAddress.of("svlada@gmail.com"))
				.subject(Subject.of("Subject"))
				.content(Content.of("Test email"))
				.build();
		
		mailSender.send(email);
	}
}
