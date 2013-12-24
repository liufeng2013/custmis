package com.tapestry.app.pages.js;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.InitializationPriority;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

public class Scriptaculous {

	@Property
	private String firstName;
	@Property
	private String lastName;
	@Inject
	private JavaScriptSupport javaScriptSupport;

	public void setupRender() {
		javaScriptSupport.addScript(InitializationPriority.LATE,
				String.format("Effect.Grow('%s');", "expando"));
	}
}
