package com.svlada.ziggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.svlada.ziggy.email.Content;
import com.svlada.ziggy.email.EmailAddress;
import com.svlada.ziggy.email.Subject;

/**
 * Represents email object.
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
	
	public static FromStep builder() {
		return new Builder();
	}

	public interface FromStep {
		ToStep from(EmailAddress from);
	}
	
	public interface ToStep {
		SubjectStep to(EmailAddress... from);
	}
	
	public interface SubjectStep {
		ContentStep subject(Subject subject);
	}
	
	public interface ContentStep {
		Build content(Content content);
	}
	
	public interface Build {
		Email build();
		Build cc(EmailAddress... cc);
		Build bcc(EmailAddress... bcc);
	}
	
	public static class Builder implements FromStep, ToStep, SubjectStep, ContentStep, Build {
		private EmailAddress from;
		private List<EmailAddress> to;
		private List<EmailAddress> cc;
		private List<EmailAddress> bcc;
		private Subject subject;
		private Content content;
		
		@Override
		public Email build() {
			return new Email(this);
		}
		@Override
		public Build cc(EmailAddress... cc) {
			Objects.requireNonNull(cc);
			this.cc = new ArrayList<EmailAddress>(Arrays.asList(cc));
			return this;
		}
		@Override
		public Build bcc(EmailAddress... bcc) {
			Objects.requireNonNull(bcc);
			this.bcc = new ArrayList<EmailAddress>(Arrays.asList(bcc));
			return this;
		}
		@Override
		public Build content(Content content) {
			Objects.requireNonNull(content);
			this.content = content;
			return this;
		}
		@Override
		public ContentStep subject(Subject subject) {
			Objects.requireNonNull(subject);
			this.subject = subject;
			return this;
		}
		@Override
		public SubjectStep to(EmailAddress... to) {
			Objects.requireNonNull(to);
			this.to = new ArrayList<EmailAddress>(Arrays.asList(to));
			return this;
		}
		@Override
		public ToStep from(EmailAddress from) {
			Objects.requireNonNull(from);
			this.from = from;
			return this;
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

	public EmailAddress getFrom() {
		return from;
	}

	public List<EmailAddress> getTo() {
		return to;
	}

	public List<EmailAddress> getCc() {
		return cc;
	}

	public List<EmailAddress> getBcc() {
		return bcc;
	}

	public Subject getSubject() {
		return subject;
	}

	public Content getContent() {
		return content;
	}
	
}
