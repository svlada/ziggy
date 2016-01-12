package com.svlada.ziggy.mailsender;

public class AmazonMailSenderFactory implements MailSenderFactory {

	private AmazonMailSenderFactory() { }
	
	public static AmazonMailSenderFactory of() {
		return new AmazonMailSenderFactory();
	}
	
	@Override
	public AmazonMailSender create() {
		return AmazonMailSender.of();
	}

}
