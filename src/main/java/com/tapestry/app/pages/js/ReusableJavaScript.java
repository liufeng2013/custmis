package com.tapestry.app.pages.js;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = "context:assets/js/textbox_hint.js")
public class ReusableJavaScript {

	@Property
	@SuppressWarnings("unused")
	private String firstName;
	@Property
	@SuppressWarnings("unused")
	private String lastName;
	@Inject
	private JavaScriptSupport javaScriptSupport;

	public void setupRender() {
		javaScriptSupport.addScript(String.format(
				"new  TextboxHint('%s','%s','%s');", "firstName",
				"Enter First Name", "#ff6600"));
		javaScriptSupport.addScript(String.format(
				"new  TextboxHint('%s','%s','%s');", "lastName",
				"Enter Last Name", "blue"));
	}
}