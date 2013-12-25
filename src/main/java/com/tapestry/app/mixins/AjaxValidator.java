package com.tapestry.app.mixins;

import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = "context:assets/js/AjaxValidator.js")
public class AjaxValidator {
	@Inject
	private ComponentResources componentResources;
	@Inject
	private JavaScriptSupport javaScriptSupport;
	@InjectContainer
	private ClientElement clientElement;

	void afterRender() {
		JSONObject spec = new JSONObject();
		spec.put("elementId", clientElement.getClientId());
		spec.put("listenerURI",
				componentResources.createEventLink("ajaxValidate")
						.toAbsoluteURI());
		javaScriptSupport.addInitializerCall("ajaxValidator", spec);
	}
}
