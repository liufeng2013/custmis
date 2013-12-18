package com.tapestry.app.pages.validator;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;

public class CValidators1 {

	@Property
	@Validate("required")
	private String firstName;
	
	@Property
	@Validate("required")
	private String lastName;
	
	@InjectPage
	private CValidators2 validators2;
	
	Object onSuccess(){
		validators2.set(firstName, lastName);
		return validators2;
	}
}
