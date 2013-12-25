package com.tapestry.app.pages.ajax;

public class AJAXValidators2 {

	private String firstName;
	private String lastName;

	public void set(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	String[] onPassivate() {
		return new String[] { firstName, lastName };
	}

	void onActivate(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getName() {
		return firstName + " " + lastName;
	}
}
