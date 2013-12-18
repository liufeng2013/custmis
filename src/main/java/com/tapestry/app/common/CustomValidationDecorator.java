package com.tapestry.app.common;

import org.apache.tapestry5.BaseValidationDecorator;
import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.ValidationTracker;
import org.apache.tapestry5.corelib.components.RadioGroup;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.services.Environment;

public class CustomValidationDecorator extends BaseValidationDecorator {

	private final Environment environment;
	private final MarkupWriter markupWriter;
	
	public CustomValidationDecorator(Environment environment, MarkupWriter markupWriter) {
		this.environment = environment;
		this.markupWriter = markupWriter;
	}
	
	@Override
	public void insideLabel(Field field, Element element) {
		final String radioGroupClassName = RadioGroup.class.getName();
		
		if(field == null) {
			return;
		}
		
		if(!field.getClass().getName().equals(radioGroupClassName)) {
			if(field.isRequired()) {
				element.addClassName("required-label");
				element.getContainer().addClassName("required-label-c");
			}
		}
		
		if(inError(field)) {
			element.addClassName("error-label");
			element.getContainer().addClassName("error-label-c");
		}
	}
	
	public void insideField(Field field) {
		if(field.isRequired()) {
			getElement().addClassName("required-field");
			getElement().getContainer().addClassName("required-field-c");
		}
		
		if(inError(field)){
			getElement().addClassName("error-field");
			getElement().getContainer().addClassName("error-field-c");
		}
	}
	
	private boolean inError(Field field) {
		ValidationTracker tracker = getTracker();
		return tracker.inError(field);
	}
	
	private ValidationTracker getTracker() {
		return environment.peekRequired(ValidationTracker.class);
	}
	
	private Element getElement() {
		return markupWriter.getElement();
	}
}
