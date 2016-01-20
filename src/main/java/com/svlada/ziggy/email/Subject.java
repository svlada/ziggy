package com.svlada.ziggy.email;

import java.util.Objects;

public class Subject {
	
	private final String value;

	private Subject(String subject) {
		this.value = subject;
	}
	
	public static Subject of(String subject) {
		Objects.requireNonNull(subject, "Email subject must not be null");
		if (subject.isEmpty()) throw new IllegalArgumentException("Email subject length must be greater than 0");
		return new Subject(subject);
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
}
