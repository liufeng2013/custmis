package com.tapestry.app.components;

import org.apache.tapestry5.Field;
import org.apache.tapestry5.FormValidationControl;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.ValidationDecorator;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.SupportsInformalParameters;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Environment;

import com.tapestry.app.common.CustomValidationDecorator;

@SupportsInformalParameters
public class CustomForm implements FormValidationControl {

	@Inject
	private Environment environment;
	
	@Component(id="form",publishParameters="context,tracker,clientValidation,zone,secure,validationId,validate,class",inheritInformalParameters=true)
	private Form form;
	
	void beginRender(MarkupWriter writer) {
		environment.push(ValidationDecorator.class, new CustomValidationDecorator(environment,writer));
	}
	
	void afterRender(MarkupWriter writer) {
		environment.pop(ValidationDecorator.class);
	}
	
	public void clearErrors() {
		form.clearErrors();
	}

	public boolean getHasErrors() {
		return form.getHasErrors();
	}

	public boolean isValid() {
		return form.isValid();
	}

	public void recordError(String errorMessage) {
		form.recordError(errorMessage);
	}

	public void recordError(Field field, String errorMessage) {
		form.recordError(field, errorMessage);
	}

}
