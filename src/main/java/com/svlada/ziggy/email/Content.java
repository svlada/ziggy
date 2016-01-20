package com.svlada.ziggy.email;

import java.util.Objects;

public class Content {
	
	private final String body;

	private Content(String body) {
		super();
		this.body = body;
	}
	
	public static Content of(String body) {
		Objects.requireNonNull(body);
		if (body.isEmpty()) throw new IllegalArgumentException("Email content cannot be empty.");
		return new Content(body);
	}

	public String getBody() {
		return body;
	}
	
}
