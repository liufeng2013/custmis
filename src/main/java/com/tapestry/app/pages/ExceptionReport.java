package com.tapestry.app.pages;

import org.apache.tapestry5.services.ExceptionReporter;

public class ExceptionReport implements ExceptionReporter {

	private String error;

	public void reportException(Throwable exception) {
		error = exception.getLocalizedMessage();
	}

	public String getError() {
		return error;
	}
}
