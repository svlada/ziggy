package com.svlada.ziggy.mailsender;

import com.amazonaws.regions.Regions;

public class AmazonMailSenderFactory {

	private AmazonMailSenderFactory() { }
	
	public static AmazonMailSenderFactory of() {
		return new AmazonMailSenderFactory();
	}
	
	public AmazonMailSender create(Regions region) {
		return AmazonMailSender.of(region);
	}

}
