package com.tapestry.app.mixins;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = "context:assets/js/robust_textbox_hint.js")
public class TextboxHint {

	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String hintText;
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String hintColor;
	@Inject
	private JavaScriptSupport javaScriptSupport;
	@InjectContainer
	private ClientElement clientElement;

	public void afterRender() {
		JSONObject spec = new JSONObject();
		spec.put("textboxId", clientElement.getClientId());
		spec.put("hintText", hintText);
		spec.put("hintColor", hintColor);
		javaScriptSupport.addInitializerCall("textboxHint", spec);
	}
}
