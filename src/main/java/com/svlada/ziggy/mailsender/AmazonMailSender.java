package com.svlada.ziggy.mailsender;

import com.svlada.ziggy.Email;

public class AmazonMailSender implements MailSender {

	private AmazonMailSender() { }
	
	public static AmazonMailSender of() {
		return new AmazonMailSender();
	}
	
	public void send(Email email) {
		
	}
	
}
