package com.svlada.ziggy.email;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Representation of valid email address
 * 
 * @author vladimir.stankovic
 *
 */
public class EmailAddress {

	private final String address;

	private EmailAddress(String address) {
		this.address = address;
	}

	/**
	 * Factory method for creating email address object with valid email address.
	 * 
	 * @throws {@IllegalArgumentException} when provided email address is not valid.
	 * @param address
	 * @return
	 */
	public static EmailAddress of(String address) {
		if (address == null || address.isEmpty()) throw new IllegalArgumentException();
		
		try {
			new InternetAddress(address, true);
		} catch (AddressException ex) {
			throw new IllegalArgumentException();
		}
		
		return new EmailAddress(address);
	}
	
	@Override
	public String toString() {
		return address;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		EmailAddress other = (EmailAddress) obj;

		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		return true;
	}

}
