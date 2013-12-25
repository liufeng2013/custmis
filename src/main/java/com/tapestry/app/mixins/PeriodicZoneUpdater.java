package com.tapestry.app.mixins;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = "context:assets/js/PeriodicZoneUpdater.js")
public class PeriodicZoneUpdater {

	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String event;
	@Parameter
	private Object[] context;
	@Parameter(defaultPrefix = BindingConstants.LITERAL, required = true)
	private int frequencySecs;
	@Parameter(defaultPrefix = BindingConstants.LITERAL, required = true)
	private int maxUpdates;
	@Inject
	private ComponentResources componentResources;
	@Inject
	private JavaScriptSupport javaScriptSupport;
	@InjectContainer
	private ClientElement clientElement;

	void afterRender() {
		JSONObject spec = new JSONObject();
		spec.put("zoneElementId", clientElement.getClientId());
		spec.put("eventURL", componentResources.createEventLink(event, context)
				.toAbsoluteURI());
		spec.put("frequencySecs", frequencySecs);
		spec.put("maxUpdates", maxUpdates);
		javaScriptSupport.addInitializerCall("periodicZoneUpdater", spec);
	}
}
