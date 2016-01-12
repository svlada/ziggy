package com.svlada.ziggy.mailsender;

public class AmazonMailSender implements MailSender {

	private AmazonMailSender() { }
	
	public static AmazonMailSender of() {
		return new AmazonMailSender();
	}
	
}
