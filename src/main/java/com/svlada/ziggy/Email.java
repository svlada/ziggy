package com.svlada.ziggy;

import java.util.List;

import com.svlada.ziggy.email.Content;
import com.svlada.ziggy.email.EmailAddress;
import com.svlada.ziggy.email.Subject;

/**
 * Represents email object
 * 
 * @author vladimir.stankovic
 *
 */
public class Email {

	private EmailAddress from;

	private List<EmailAddress> to;

	private List<EmailAddress> cc;

	private List<EmailAddress> bcc;

	private Subject subject;

	private Content content;

	public static class Builder {
		private EmailAddress from;
		private List<EmailAddress> to;
		private List<EmailAddress> cc;
		private List<EmailAddress> bcc;
		private Subject subject;
		private Content content;

		public Builder from(EmailAddress from) {
			this.from = from;
			return this;
		}

		public Builder to(List<EmailAddress> to) {
			this.to = to;
			return this;
		}

		public Builder cc(List<EmailAddress> cc) {
			this.cc = cc;
			return this;
		}

		public Builder bcc(List<EmailAddress> bcc) {
			this.bcc = bcc;
			return this;
		}

		public Builder subject(Subject subject) {
			this.subject = subject;
			return this;
		}

		public Builder content(Content content) {
			this.content = content;
			return this;
		}

		public Email build() {
			return new Email(this);
		}
	}

	private Email(Builder builder) {
		this.from = builder.from;
		this.to = builder.to;
		this.cc = builder.cc;
		this.bcc = builder.bcc;
		this.subject = builder.subject;
		this.content = builder.content;
	}
}
