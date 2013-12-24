package com.tapestry.app.pages.js;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = "context:assets/js/JavaScript.js")
public class JavaScript {

	@Property
	private String firstName;
	@Inject
	private JavaScriptSupport javaScriptSupport;

	public void setupRender() {
		javaScriptSupport.addScript("new ColorSwitcher();");
	}
}
