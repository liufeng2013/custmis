package com.tapestry.app.pages.form;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;

public class Forms1 {

	@Property
	private String firstName;
	@Property
	private String lastName;
	
	@Component(id="myForm")
	private Form form;
	
	@Component(id="firstName")
	private TextField firstNameField;
	@Component(id="lastName")
	private TextField lastNameField;
	
	@InjectPage
	private Forms2 forms2;
	
	void onValidateFromMyForm() {
		if(firstName == null || "".equals(firstName.trim())) {
			form.recordError(firstNameField, "姓不能为空值!");
		}
		if(lastName == null || "".equals(lastName.trim())) {
			form.recordError(lastNameField, "名字不能为空值!");
		}
	}
	
	Object onSuccess() {
		forms2.setFirstName(firstName);
		forms2.setLastName(lastName);
		
		return forms2;
	}
}
