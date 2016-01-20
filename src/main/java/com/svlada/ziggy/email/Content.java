package com.svlada.ziggy.email;

import java.util.Objects;

public class Content {
	
	private final String value;

	private Content(String body) {
		super();
		this.value = body;
	}
	
	public static Content of(String body) {
		Objects.requireNonNull(body);
		if (body.isEmpty()) throw new IllegalArgumentException("Email content cannot be empty.");
		return new Content(body);
	}

	@Override
	public String toString() {
		return value;
	}
	
}
