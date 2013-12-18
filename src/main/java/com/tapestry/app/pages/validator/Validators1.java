package com.tapestry.app.pages.validator;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;

public class Validators1 {

	@Property
	@Validate("required")
	private String firstName;
	@Property
	@Validate("required")
	private String lastName;
	
	@InjectPage
	private Validators2 validators2;
	
	Object onSuccess() {
		validators2.set(firstName, lastName);
		return validators2;
	}
}
