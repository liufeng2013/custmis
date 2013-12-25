package com.tapestry.app.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

public class Error404 {

	@Property
	@Inject
	private Request request;
}
