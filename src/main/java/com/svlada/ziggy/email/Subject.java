package com.svlada.ziggy.email;

import java.util.Objects;

public class Subject {
	
	private final String subject;

	private Subject(String subject) {
		this.subject = subject;
	}
	
	public static Subject of(String subject) {
		Objects.requireNonNull(subject, "Email subject must not be null");
		if (subject.isEmpty()) throw new IllegalArgumentException("Email subject length must be greater than 0");
		return new Subject(subject);
	}

	public String getSubject() {
		return subject;
	}
	
}
