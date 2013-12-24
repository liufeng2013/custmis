package com.tapestry.app.pages.js;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = "context:assets/js/robust_textbox_hint.js")
public class RobustJavaScript {

	@Property
	private String firstName;
	@Property
	private String lastName;
	@Property
	private String firstNameId;
	@Property
	private String lastNameId;
	@Inject
	private JavaScriptSupport javaScriptSupport;

	public void setupRender() {
		firstNameId = "firstName";
		lastNameId = "lastName";
		JSONObject spec = new JSONObject();
		spec.put("textboxId", firstNameId);
		spec.put("hintText", "Enter First Name");
		spec.put("hintColor", "#ff6600");
		javaScriptSupport.addInitializerCall("textboxHint", spec);
		JSONObject spec2 = new JSONObject();
		spec2.put("textboxId", lastNameId);
		spec2.put("hintText", "Enter Last Name");
		spec2.put("hintColor", "#808080");
		javaScriptSupport.addInitializerCall("textboxHint", spec2);
	}
}
