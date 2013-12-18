package com.tapestry.app.pages.form;

import org.apache.tapestry5.annotations.Persist;

public class Forms2 {

	@Persist
	private String firstName;
	@Persist
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
