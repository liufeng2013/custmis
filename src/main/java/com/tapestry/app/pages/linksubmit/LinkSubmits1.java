package com.tapestry.app.pages.linksubmit;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;

public class LinkSubmits1 {

	@Persist
	@Property
	private String firstName;
	
	@Persist
	@Property
	private String lastName;
	
	@Persist
	@Property
	private String selectName;
	
	@Component(id="names")
	private Form form;
	
	@Component(id="firstName")
	private TextField firstNameField;
	
	@Component(id="lastName")
	private TextField lastNameField;
	
	void onValidateFromNames() {
		if(firstName == null || firstName.trim().equals("")) {
			form.recordError(firstNameField, "First Name is required.");
		}
		if(lastName == null || lastName.trim().equals("")) {
			form.recordError(lastNameField, "Last Name is required.");
		}
	}
	
	Object onSuccess() {
		selectName = firstName + lastName;
		return this;
	}
}
