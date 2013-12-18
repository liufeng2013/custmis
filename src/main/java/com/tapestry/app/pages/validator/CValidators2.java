package com.tapestry.app.pages.validator;

public class CValidators2 {

	private String firstName;
	private String lastName;
	
	public void set(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	String[] onPassivate() {
		return new String[]{firstName, lastName};
	}
	
	void onActivate(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
