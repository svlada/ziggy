package com.svlada.ziggy;

import org.apache.log4j.Logger;

import com.svlada.ziggy.email.EmailAddress;
import com.svlada.ziggy.mailsender.AmazonMailSender;
import com.svlada.ziggy.mailsender.AmazonMailSenderFactory;

public class App {
	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(App.class);
		
		EmailAddress.of("svlada@gmail.com");
		
		AmazonMailSender mailSender = AmazonMailSenderFactory.of().create();
	}
}
