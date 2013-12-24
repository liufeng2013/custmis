package com.tapestry.app.mixins;

import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = "context:assets/js/ClickOnce.js")
public class ClickOnce {

	@Inject
	private JavaScriptSupport javaScriptSupport;
	@InjectContainer
	private ClientElement clientElement;

	public void afterRender() {
		JSONObject spec = new JSONObject();
		spec.put("elementId", clientElement.getClientId());
		javaScriptSupport.addInitializerCall("clickOnce", spec);
	}
}
